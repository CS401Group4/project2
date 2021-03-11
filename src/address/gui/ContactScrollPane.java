package address.gui;

import address.AddressBook;
import address.data.AddressEntry;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that holds the AddressBook instance for the application
 *
 * @author Tey Jon Sornet
 * @since February 2021
 */
public class ContactScrollPane extends JFrame {
    /**
     * Create AddressBook instance
     */
    protected static AddressBook addressBook = new AddressBook();

    /**
     * Create DefaultListModel instance
     */
    protected static DefaultListModel<AddressEntry> myAddressEntryListModel = new DefaultListModel<>();

    /**
     * Create a JList instance for the scroll pane
     */
    protected static JList<AddressEntry> addressEntryJList;

    /**
     * JPanel object which holds the scrollpane
     */
    protected static JPanel contactScrollPanel;

    /**
     * Remove button
     */
    private static JButton btnRemove;

    /**
     * Add button
     */
    private static JButton btnAdd;

    /**
     * Update button
     */
    private static JButton btnUpdate;

    /**
     * JScrollPane object which will hold the AddressBook entries
     */
    private static JScrollPane scrollPane;

    /**
     * JPanel object which holds the add, remove and update buttons
     */
    private static JPanel buttonPanel;

    /**
     * Constructor to read AddressEntry entries into application and
     * initializes the application
     */
    public ContactScrollPane() {
        try {
            // Read data from file and add to AddressBook
            // init("./AddressInputDataFile1.txt");

            loadFromDB();
            initialize();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to load data from database
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void loadFromDB() throws ClassNotFoundException, SQLException, FileNotFoundException {
        // Load Oracle JDBC Driver
        Class.forName("oracle.jdbc.OracleDriver");

        // Retrieve jdbc credentials
        String username, pwd;
        File file = new File("credentials.txt");
        Scanner input = new Scanner(file);
        username = input.nextLine();
        pwd = input.nextLine();

        // Connect to database
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:" + username + "/" + pwd + "@adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu");

        // Create a statement
        Statement stmt = conn.createStatement();

        // Select ALL from ADDRESSENTRYTABLE
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM ADDRESSENTRYTABLE");

        // Iterate through result and print employee names
        while (resultSet.next()) {
            // Collection to add data from table row
            ArrayList<String> data = new ArrayList();

            // Visit each column and add to collection
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                data.add(resultSet.getString(i));
            }

            // Parse collection and create new AddressEntry and add to AddressBook
            AddressEntry addressEntry = new AddressEntry(Integer.parseInt(data.get(0)), data.get(1).trim(), data.get(2).trim(), data.get(3).trim(), data.get(4).trim(), data.get(5).trim(), Integer.parseInt(data.get(6)), data.get(7).trim(), data.get(8).trim());
            addressBook.getAddressEntryList().add(addressEntry);
        }

        addressBook.list();

        // Close access to everything
        resultSet.close();
        stmt.close();
        conn.close();
    }

    /**
     * Method to read entries from a file and creates a new AddressEntry
     * instance for each entry. Also adds the AddressEntry into the
     * AddressBook instance that was passed as a parameter
     *
     * @param filename a String object
     */
    public void init(String filename) {
        try {
            // Create instance of File
            File file = new File(filename);
            Scanner input = new Scanner(file);

            // Iterate through txt file
            while (input.hasNextLine()) {
                int id = addressBook.getAddressEntryList().size() + 1;

                // Create AddressEntry instance then add to AddressBook instance
                AddressEntry entry = new AddressEntry(id, input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), Integer.parseInt(input.nextLine()), input.nextLine(), input.nextLine());
                addressBook.add(entry);
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that creates the Contact scroll window section which also
     * include the add, remove and update buttons
     */
    public static void initialize() {
        // Create a new instance of JPanel which will be the parent container
        contactScrollPanel = new JPanel();

        // Add all AddressEntry entries into a ListModel
        myAddressEntryListModel.addAll(addressBook.getAddressEntryList());

        // Create a JList object from the ListModel
        addressEntryJList = new JList<>(myAddressEntryListModel);

        // Only allow single selection in the scrollpane
        addressEntryJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        addressEntryJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        addressEntryJList.setVisibleRowCount(-1);

        // Add event listener for scrollpane to detect if a selection is made
        addressEntryJList.addListSelectionListener(
                new ListSelectionListener() {
                    // If one of the list is selected, enable Remove button
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        // Enable remove and update buttons if
                        // something is selected. Otherwise, keep buttons
                        // disabled
                        if (addressEntryJList.isSelectionEmpty()) {
                            btnRemove.setEnabled(false);
                            btnUpdate.setEnabled(false);
                        } else {
                            btnRemove.setEnabled(true);
                            btnUpdate.setEnabled(true);
                        }
                    }
                }
        );

        // Set the layout of the main container
        contactScrollPanel.setLayout(new BoxLayout(contactScrollPanel, BoxLayout.Y_AXIS));

        // Create add, remove and update button and put it
        // in a buttonPanel container
        buttonPanel = new JPanel();
        btnAdd = new JButton("New");
        btnUpdate = new JButton("Update");
        btnRemove = new JButton("Remove");
        btnRemove.setEnabled(false);
        btnUpdate.setEnabled(false);

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnRemove);

        // Create scrollpane associated with JList
        JPanel scrollPanel = new JPanel();
        scrollPane = new JScrollPane(addressEntryJList);
        scrollPane.setPreferredSize(new Dimension(600, 200));
        scrollPanel.add(scrollPane);

        // Add scrollpane and button panel to main container
        contactScrollPanel.add(scrollPanel);
        contactScrollPanel.add(buttonPanel);
        contactScrollPanel.setVisible(false);

        // Event listener for Remove button
        btnRemove.addActionListener(new ActionListener() {
            // BASED ON event from hitting remove button,
            // Remove item from our JList's ListModel
            public void actionPerformed(ActionEvent arg0) {
                int index = addressEntryJList.getSelectedIndex();

                //something is selected otherwise do nothing
                if (index != -1) {
                    // Retrieve the DefaultListModel associated
                    // with our JList and remove from it the AddressEntry at this index
                    ((DefaultListModel<AddressEntry>) (addressEntryJList.getModel())).remove(index);

                    // NOTE in your project 2 you will also remove it from your AddressBook.addressEntryList
                    // AND ALSO remove it from the associated database table
                    addressBook.remove(addressBook.getAddressEntryList().get(index));
                    addressBook.list();
                }
            }
        });

        // Event listener for Add button
        btnAdd.addActionListener(new ActionListener() {
            // BASED ON event from hitting add button,
            // Add item to our JList's ListModel
            public void actionPerformed(ActionEvent event) {
                AddEntryForm addEntryForm = new AddEntryForm();
                addEntryForm.setVisible(true);
            }
        });

        // Event listener for Update button
        btnUpdate.addActionListener(new ActionListener() {
            // BASED ON event from hitting add button,
            // Add item to our JList's ListModel
            public void actionPerformed(ActionEvent event) {
                int indexToUpdate = addressEntryJList.getSelectedIndex();

                //something is selected otherwise do nothing
                if (indexToUpdate != -1) {
                    // Retrieve the DefaultListModel associated
                    // with our JList and open AddEntryForm GUI with
                    // selected entry. Them remove entry from list
                    AddEntryForm addEntryForm = new AddEntryForm(addressEntryJList.getModel().getElementAt(indexToUpdate));
                    addEntryForm.setVisible(true);
                    addEntryForm.addBtn.setText("Update");
                    ((DefaultListModel<AddressEntry>) (addressEntryJList.getModel())).remove(indexToUpdate);

                    addressBook.remove(addressBook.getAddressEntryList().get(indexToUpdate));
                    addressBook.list();
                }
            }
        });
    }
}
