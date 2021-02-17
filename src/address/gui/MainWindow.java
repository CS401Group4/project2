package address.gui;

import address.data.AddressEntry;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MainWindow {
    private JFrame frame;
    Vector<AddressEntry> addressEntryList = new Vector<>();
    JList<AddressEntry> addressEntryJList;
    DefaultListModel<AddressEntry> myAddressEntryListModel = new DefaultListModel<>();
    JButton btnRemove;

    /**
     * Launch the application
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainWindow window = new MainWindow();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application
     */
    public MainWindow() {
        addressEntryList.add(new AddressEntry(1, "Lynne", "Grewe", "33 A street", "Hayward", "CA", 9399,"l@csueastbay.edu","555-1212"));
        addressEntryList.add(new AddressEntry(2, "Jane", "Doe", "22 Cobble street", "Hayward", "CA", 9399,"jane@csueastbay.edu","555-9999"));
        addressEntryList.add(new AddressEntry(1, "Lynne", "Grewe", "33 A street", "Hayward", "CA", 9399,"l@csueastbay.edu","555-1212"));
        addressEntryList.add(new AddressEntry(2, "Jane", "Doe", "22 Cobble street", "Hayward", "CA", 9399,"jane@csueastbay.edu","555-9999"));
        addressEntryList.add(new AddressEntry(1, "Lynne", "Grewe", "33 A street", "Hayward", "CA", 9399,"l@csueastbay.edu","555-1212"));
        addressEntryList.add(new AddressEntry(2, "Jane", "Doe", "22 Cobble street", "Hayward", "CA", 9399,"jane@csueastbay.edu","555-9999"));

        for (int i = 0; i < addressEntryList.size(); i++) {
            this.myAddressEntryListModel.add(i, this.addressEntryList.elementAt(i));
        }

        addressEntryJList = new JList<>(this.myAddressEntryListModel);

        //setting up the look of the JList
        this.addressEntryJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.addressEntryJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        this.addressEntryJList.setVisibleRowCount(-1);
        this.addressEntryJList.addListSelectionListener(
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if (addressEntryJList.isSelectionEmpty()) {
                            btnRemove.setEnabled(false);
                        } else {
                            btnRemove.setEnabled(true);
                        }
                    }
                }
        );

        //setup GUI and use the JList we created
        initialize();
    }

    /**
     * Initialize the contents of the frame
     */
    private void initialize() {
        frame = new JFrame("Address Book");
        frame.setLayout(new FlowLayout());
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(780, 960);

        // create add button
        JButton btnAdd = new JButton("Add New Entry");
        frame.add(btnAdd);

        //create scrollPane associated with JList
        JScrollPane scrollPane = new JScrollPane(this.addressEntryJList);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        btnRemove = new JButton("Remove Selected Entry");
        btnRemove.setEnabled(false);
        frame.add(btnRemove);

        btnRemove.addActionListener(new ActionListener() {
            //BASED ON event from hitting remove button,
            //Remove item from our JList's ListModel

            public void actionPerformed(ActionEvent arg0) {
                int index = addressEntryJList.getSelectedIndex();

                //something is selected otherwise do nothing
                if (index != -1) {
                    //retrieve the DefaultListModel associated
                    // with our JList and remove from it the AddressEntry at this index
                    ((DefaultListModel<AddressEntry>) (addressEntryJList.getModel())).remove(index);

                    // NOTE in your project 2 you will also remove it from your AddressBook.addressEntryList
                    // AND ALSO remove it from the associated database table
                }
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            //BASED ON event from hitting add button,
            //Add item to our JList's ListModel

            public void actionPerformed(ActionEvent event) {
                AddEntryForm addEntryForm = new AddEntryForm();
                addEntryForm.setVisible(true);
            }
        });
    }
}
