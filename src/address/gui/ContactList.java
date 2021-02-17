package address.gui;

import address.data.AddressEntry;

import javax.swing.*;
import java.util.Vector;

public class ContactList extends JFrame {
    Vector<AddressEntry> addressEntryList = new Vector<>();

    public ContactList() {
        addressEntryList.add(new AddressEntry(1, "Lynne", "Grewe", "33 A street", "Hayward", "CA", 9399,"l@csueastbay.edu","555-1212"));
        addressEntryList.add(new AddressEntry(2, "Jane", "Doe", "22 Cobble street", "Hayward", "CA", 9399,"jane@csueastbay.edu","555-9999"));
        addressEntryList.add(new AddressEntry(1, "Lynne", "Grewe", "33 A street", "Hayward", "CA", 9399,"l@csueastbay.edu","555-1212"));
        addressEntryList.add(new AddressEntry(2, "Jane", "Doe", "22 Cobble street", "Hayward", "CA", 9399,"jane@csueastbay.edu","555-9999"));
        addressEntryList.add(new AddressEntry(1, "Lynne", "Grewe", "33 A street", "Hayward", "CA", 9399,"l@csueastbay.edu","555-1212"));
        addressEntryList.add(new AddressEntry(2, "Jane", "Doe", "22 Cobble street", "Hayward", "CA", 9399,"jane@csueastbay.edu","555-9999"));
    }
}
