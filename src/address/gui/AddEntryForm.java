package address.gui;

import address.data.AddressEntry;
import address.gui.event.TextChangeDocumentListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI class for rendering a form to add a new AddressEntry
 *
 * @author Tey Jon Sornet
 * @since February 2021
 */
public class AddEntryForm extends JDialog {
    /**
     * First Name value
     */
    private String fName;
    /**
     * Last Name value
     */
    private String lName;
    /**
     * Street Name value
     */
    private String streetName;
    /**
     * City Name value
     */
    private String cityName;
    /**
     * State value
     */
    private String stateName;
    /**
     * Zip value
     */
    private int zipValue;
    /**
     * Phone number value
     */
    private String phoneValue;
    /**
     * Email value
     */
    private String emailValue;

    /**
     * Text field for first name
     */
    private JTextField firstName = new JTextField(30);
    /**
     * Text field for last name
     */
    private JTextField lastName = new JTextField(30);
    /**
     * Text field for street name
     */
    private JTextField street = new JTextField(30);
    /**
     * Text field for city name
     */
    private JTextField city = new JTextField(30);
    /**
     * Text field for state value
     */
    private JTextField state = new JTextField(30);
    /**
     * Text field for zip value
     */
    private JTextField zip = new JTextField(30);
    /**
     * Text field for phone number value
     */
    private JTextField phone = new JTextField(30);
    /**
     * Text field for email value
     */
    private JTextField email = new JTextField(30);

    /**
     * Label for first name field
     */
    private final JLabel firstNameLabel = new JLabel("First Name ");
    /**
     * Label for last name field
     */
    private final JLabel lastNameLabel = new JLabel("Last Name ");
    /**
     * Label for street name field
     */
    private final JLabel streetLabel = new JLabel("Street ");
    /**
     * Label for city name field
     */
    private final JLabel cityLabel = new JLabel("City ");
    /**
     * Label for state field
     */
    private final JLabel stateLabel = new JLabel("State ");
    /**
     * Label for zip field
     */
    private final JLabel zipLabel = new JLabel("Zip ");
    /**
     * Label for phone number field
     */
    private final JLabel phoneLabel = new JLabel("Phone ");
    /**
     * Label for email value field
     */
    private final JLabel emailLabel = new JLabel("Email ");

    /**
     * Button to add an entry
     */
    protected JButton addBtn;

    /**
     * Class constructor
     * Creates a new container for the add entry form and adds the text fields
     * and labels. Also adds event listeners for the text fields and the Add
     * button
     */
    public AddEntryForm() {
        initialize();
    }

    /**
     * Class constructor which takes in an AddressEntry object
     * Creates a new container for the add entry form and adds the text fields
     * and labels. Also adds event listeners for the text fields and the Add
     * button
     */
    public AddEntryForm(AddressEntry addressEntry) {
        fName = addressEntry.getName().getFirstName();
        firstName.setText(fName);

        lName = addressEntry.getName().getLastName();
        lastName.setText(lName);

        streetName = addressEntry.getAddress().getStreet();
        street.setText(streetName);

        cityName = addressEntry.getAddress().getCity();
        city.setText(cityName);

        stateName = addressEntry.getAddress().getState();
        state.setText(stateName);

        zipValue = addressEntry.getAddress().getZip();
        zip.setText(Integer.toString(zipValue));

        phoneValue = addressEntry.getPhone();
        phone.setText(phoneValue);

        emailValue = addressEntry.getEmail();
        email.setText(emailValue);

        initialize();
    }

    /**
     * Method that creates a container to hold the Address entry form
     * and attaches event listeners to the text fields and buttons
     */
    public void initialize() {
        // Create container to hold text fields and labels
        setBounds(132, 132, 300, 500);
        Box container = Box.createVerticalBox();

        // Add labels and text fields to container
        container.add(new JLabel("Add New Entry"));
        container.add(firstNameLabel);
        container.add(firstName);
        container.add(lastNameLabel);
        container.add(lastName);
        container.add(streetLabel);
        container.add(street);
        container.add(cityLabel);
        container.add(city);
        container.add(stateLabel);
        container.add(state);
        container.add(zipLabel);
        container.add(zip);
        container.add(phoneLabel);
        container.add(phone);
        container.add(emailLabel);
        container.add(email);
        add(container);

        // Create a panel to hold the Add button
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        addBtn = new JButton("Add");
        addBtn.setEnabled(false);

        // Add event listener to button
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = ContactScrollPane.addressBook.getAddressEntryList().size() + 1;
                AddressEntry addressEntry = new AddressEntry(id, fName, lName, streetName, cityName, stateName, zipValue, phoneValue, emailValue);

                ContactScrollPane.addressBook.add(addressEntry);
                ContactScrollPane.myAddressEntryListModel.removeAllElements();
                ContactScrollPane.myAddressEntryListModel.addAll(ContactScrollPane.addressBook.getAddressEntryList());
                ContactScrollPane.addressBook.list();
                setVisible(false);
            }
        });

        // Add event listener for first name text field
        firstName.getDocument().addDocumentListener(
                new TextChangeDocumentListener() {
                    @Override
                    public void update(DocumentEvent e) {
                        fName = firstName.getText();
                        validateForm();
                    }
                }
        );

        // Add event listener for last name text field
        lastName.getDocument().addDocumentListener(
                new TextChangeDocumentListener() {
                    @Override
                    public void update(DocumentEvent e) {
                        lName = lastName.getText();
                        validateForm();
                    }
                }
        );

        // Add event listener for street name text field
        street.getDocument().addDocumentListener(
                new TextChangeDocumentListener() {
                    @Override
                    public void update(DocumentEvent e) {
                        streetName = street.getText();
                        validateForm();
                    }
                }
        );

        // Add event listener for city name text field
        city.getDocument().addDocumentListener(
                new TextChangeDocumentListener() {
                    @Override
                    public void update(DocumentEvent e) {
                        cityName = city.getText();
                        validateForm();
                    }
                }
        );

        // Add event listener for state text field
        state.getDocument().addDocumentListener(
                new TextChangeDocumentListener() {
                    @Override
                    public void update(DocumentEvent e) {
                        stateName = state.getText();
                        validateForm();
                    }
                }
        );

        // Add event listener for zip text field
        zip.getDocument().addDocumentListener(
                new TextChangeDocumentListener() {
                    @Override
                    public void update(DocumentEvent e) {
                        // Regex to check if input is digits
                        String regex = "\\d+";

                        // Only assign value when zip text field is not empty and
                        // if it matches regex
                        if (!zip.getText().isEmpty() && zip.getText().matches(regex)) {
                            zipValue = Integer.parseInt(zip.getText());
                            validateForm();
                        }
                    }
                }
        );

        // Add event listener for phone text field
        phone.getDocument().addDocumentListener(
                new TextChangeDocumentListener() {
                    @Override
                    public void update(DocumentEvent e) {
                        phoneValue = phone.getText();
                        validateForm();
                    }
                }
        );

        // Add event listener for email text field
        email.getDocument().addDocumentListener(
                new TextChangeDocumentListener() {
                    @Override
                    public void update(DocumentEvent e) {
                        emailValue = email.getText();
                        validateForm();
                    }
                }
        );

        // Add button to panel then add panel to main container
        panel.add(addBtn);
        container.add(panel);
    }

    /**
     * Method to validate the form fields. Only enables the add button
     * when all fields are filled out.
     */
    public void validateForm() {
        // Check that fields are not empty. If any of the fields are empty
        if (fName == null || fName.isEmpty()
                || lName == null || lName.isEmpty()
                || streetName == null || streetName.isEmpty()
                || cityName == null || cityName.isEmpty()
                || stateName == null || stateName.isEmpty()
                || zipValue == 0
                || phoneValue == null || phoneValue.isEmpty()
                || emailValue == null || emailValue.isEmpty()) {
            addBtn.setEnabled(false); // Keep button disabled if all fields are not filled out
        } else {
            addBtn.setEnabled(true); // Enable button once all fields are filled out
        }
    }
}
