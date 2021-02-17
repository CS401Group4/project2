package address.gui;

import address.gui.event.TextChangeDocumentListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEntryForm extends JDialog {
    private String fName;
    private String lName;
    private String streetName;
    private String cityName;
    private String stateName;
    private int zipValue;
    private String phoneValue;
    private String emailValue;

    private JTextField firstName = new JTextField(30);
    private JTextField lastName = new JTextField(30);
    private JTextField street = new JTextField(30);
    private JTextField city = new JTextField(30);
    private JTextField state = new JTextField(30);
    private JTextField zip = new JTextField(30);
    private JTextField phone = new JTextField(30);
    private JTextField email = new JTextField(30);

    private final JLabel firstNameLabel = new JLabel("First Name ");
    private final JLabel lastNameLabel = new JLabel("Last Name ");
    private final JLabel streetLabel = new JLabel("Street ");
    private final JLabel cityLabel = new JLabel("City ");
    private final JLabel stateLabel = new JLabel("State ");
    private final JLabel zipLabel = new JLabel("Zip ");
    private final JLabel phoneLabel = new JLabel("Phone ");
    private final JLabel emailLabel = new JLabel("Email ");

    public AddEntryForm() {
        setBounds(132, 132, 300, 500);
        Box container = Box.createVerticalBox();
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
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        firstName.getDocument().addDocumentListener(
                new TextChangeDocumentListener() {
                    @Override
                    public void update(DocumentEvent e) {
                        fName = firstName.getText();
                    }
                }
        );

        lastName.getDocument().addDocumentListener(
                new TextChangeDocumentListener() {
                    @Override
                    public void update(DocumentEvent e) {
                        lName = lastName.getText();
                    }
                }
        );

        street.getDocument().addDocumentListener(
                new TextChangeDocumentListener() {
                    @Override
                    public void update(DocumentEvent e) {
                        streetName = street.getText();
                    }
                }
        );

        city.getDocument().addDocumentListener(
                new TextChangeDocumentListener() {
                    @Override
                    public void update(DocumentEvent e) {
                        cityName = city.getText();
                    }
                }
        );

        state.getDocument().addDocumentListener(
                new TextChangeDocumentListener() {
                    @Override
                    public void update(DocumentEvent e) {
                        stateName = state.getText();
                    }
                }
        );

        zip.getDocument().addDocumentListener(
                new TextChangeDocumentListener() {
                    @Override
                    public void update(DocumentEvent e) {
                        zipValue = Integer.parseInt(zip.getText());
                    }
                }
        );

        phone.getDocument().addDocumentListener(
                new TextChangeDocumentListener() {
                    @Override
                    public void update(DocumentEvent e) {
                        phoneValue = phone.getText();
                    }
                }
        );

        email.getDocument().addDocumentListener(
                new TextChangeDocumentListener() {
                    @Override
                    public void update(DocumentEvent e) {
                        emailValue = email.getText();
                    }
                }
        );

        panel.add(addBtn);
        container.add(panel);
    }
}
