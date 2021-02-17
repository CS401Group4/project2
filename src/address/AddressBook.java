package address;

import address.data.AddressEntry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Holds a collection of objects of the class AddressEntry
 * Contains an add method to add new AddressEntry
 * Contains an list method to iterate through an ArrayList of AddressEntry
 *
 * @author Tey Jon Sornet
 */
public class AddressBook {
    private ArrayList<AddressEntry> addressEntryList = new ArrayList<>();

    public void list() {
        // Iterate through AddressEntry and print out the data
        for (int i = 1; i <= addressEntryList.size(); i++) {
            System.out.print(i + ": ");
            System.out.println(addressEntryList.get(i-1).toString());
        }
    }

    public void add(AddressEntry entry) {
        entry.setId(addressEntryList.size());
        addressEntryList.add(entry);
    }

    public void remove(AddressEntry entry) {
        addressEntryList.remove(entry);
    }

    public ArrayList<AddressEntry> find(String startOf_lastName) {
        Stream<AddressEntry> stream = addressEntryList.stream().filter(entry -> entry.getName().getLastName().contains(startOf_lastName));
        ArrayList<AddressEntry> result = new ArrayList<>();

        stream.forEach(s -> result.add(s));
        return result;
    }

    public ArrayList<AddressEntry> getAddressEntryList() {
        return addressEntryList;
    }
}

