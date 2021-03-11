package address.gui;

import address.data.AddressEntry;
import address.gui.event.TextChangeDocumentListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI Class for the Find entry component
 *
 * @author Tey Jon Sornet
 * @since February 2021
 */
public class FindEntryPanel {
    /**
     * Find button
     */
    private JButton btnFind;

    /**
     * Search field input
     */
    private JTextField findTextField;

    /**
     * String variable to hold value from text field
     */
    private String lastName;

    /**
     * Main container for FindEntry section
     */
    protected static JPanel findPanel;

    /**
     * Scroll window containing search results
     */
    JScrollPane findScrollPane;

    /**
     * Create ListModel object for the scrollpane
     */
    DefaultListModel<AddressEntry> myAddressEntryListModel = new DefaultListModel<>();

    /**
     * Create JList object from the ListModel instance
     */
    JList<AddressEntry> addressEntryJList = new JList<>(myAddressEntryListModel);

    /**
     * Constructor that creates FindEntry section
     */
    public FindEntryPanel() {
        // Create a new JPanel instance which will be the main container
        findPanel = new JPanel();

        // Create a new JTextField instance and add to panel
        findTextField = new JTextField(30);
        findPanel.add(findTextField);

        // Attach event listener to text field
        findTextField.getDocument().addDocumentListener(
                new TextChangeDocumentListener() {
                    @Override
                    public void update(DocumentEvent e) {
                        // Set the value of the text field to lastName when user starts
                        // typing
                        lastName = findTextField.getText();
                    }
                }
        );

        // Create a Find button and add it to panel
        btnFind = new JButton("Find");
        findPanel.add(btnFind);

        // Attach event listener to Find button
        btnFind.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Find all AddressBook entries matching with last name value
                        // entered in text field and update JList with the resulting
                        // collection
                        myAddressEntryListModel = new DefaultListModel<>();
                        myAddressEntryListModel.addAll(ContactScrollPane.addressBook.find(lastName));
                        addressEntryJList.setModel(myAddressEntryListModel);
                        addressEntryJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
                    }
                }
        );

        // Create a scroll window from the JList entries and set the size
        findScrollPane = new JScrollPane(addressEntryJList);
        findScrollPane.setPreferredSize(new Dimension(600, 200));

        // Add the scroll window to main panel and make it visible
        findPanel.add(findScrollPane);
        findPanel.setVisible(false);
    }
}
