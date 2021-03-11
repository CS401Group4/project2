package address;

import address.data.AddressEntry;

import java.sql.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * Holds a collection of objects of the class AddressEntry
 * Contains an add method to add new AddressEntry
 * Contains an list method to iterate through an ArrayList of AddressEntry
 *
 * @author Tey Jon Sornet
 * @since February 2021
 */
public class AddressBook {
    /**
     * ArrayList of AddressEntry which will be the Address Book
     */
    private Vector<AddressEntry> addressEntryList = new Vector<>();

    /**
     * Method to list all records of AddressBook
     */
    public void list() {
        addressEntryList.sort(Comparator.comparing(AddressEntry::getLastName));
        // Iterate through AddressEntry and print out the data
        for (int i = 1; i <= addressEntryList.size(); i++) {
            System.out.print(i + ": ");
            System.out.println(addressEntryList.get(i-1).toString());
        }
    }

    /**
     * Method to add a single AddressEntry into AddressBook
     * @param addressEntry AddressEntry object
     * @return
     */
    public boolean add(AddressEntry addressEntry) {
        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Connect to database
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:mcs1028/bPiR8jKZ@adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu");

            // Create a statement
            Statement statement = conn.createStatement();

            // Insert new entry to ADDRESSENTRYTABLE
            statement.executeUpdate(new StringBuilder().append("INSERT INTO ADDRESSENTRYTABLE ").append("VALUES(").append(addressEntry.getId().toString()).append(", '").append(addressEntry.getName().getFirstName()).append("', '").append(addressEntry.getName().getLastName()).append("', '").append(addressEntry.getAddress().getStreet()).append("', '").append(addressEntry.getAddress().getCity()).append("', '").append(addressEntry.getAddress().getState()).append("',").append(addressEntry.getAddress().getZip().toString()).append(",'").append(addressEntry.getPhone()).append("', '").append(addressEntry.getEmail()).append("')").toString());
            statement.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        addressEntryList.add(addressEntry);
        return false;
    }

    /**
     * Method to remove an AddressEntry from AddressBook
     * @param entry AddressEntry object
     */
    public void remove(AddressEntry entry) {
        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Connect to database
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:mcs1028/bPiR8jKZ@adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu");

            // Create a statement
            Statement statement = conn.createStatement();
            statement.executeUpdate("DELETE FROM ADDRESSENTRYTABLE WHERE ID=" + entry.getId());

            statement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        addressEntryList.remove(entry);
    }

    /**
     * Method to find collection of AddressEntry that matches a given last name
     * @param startOf_lastName String of a user's last name
     * @return collection of AddressEntry items matching last name
     */
    public Vector<AddressEntry> find(String startOf_lastName) {
        // Iterate through all entries and check for matching last name (partial or full)
        Stream<AddressEntry> stream = addressEntryList.stream().filter(entry -> entry.getName().getLastName().toLowerCase().startsWith(startOf_lastName.toLowerCase()));
        Vector<AddressEntry> result = new Vector<>(); // collection to be returned

        // Add matching entries to collection
        stream.forEach(s -> result.add(s));
        result.sort(Comparator.comparing(AddressEntry::getLastName));
        return result;
    }

    /**
     * Method to retrieve AddressBook
     * @return
     */
    public Vector<AddressEntry> getAddressEntryList() {
        addressEntryList.sort(Comparator.comparing(AddressEntry::getLastName));
        return addressEntryList;
    }
}

