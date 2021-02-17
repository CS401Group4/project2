package address;

import address.data.AddressEntry;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Creates a new instance of an AddressBook object and adds 2 AddressEntry with the given data
 * then lists the entries in the output
 */
public class AddressBookApplication {
    public static void main(String[] args) {
        // Create an instance of AddressBook
        AddressBook ab = new AddressBook();

        // Prompt for menu and retrieve selection
        char selection = Menu.prompt_Menu();

        while (selection != 'e') {
            switch(selection) {
                case 'a':
                    addEntry(ab);
                    break;
                case 'b':
                    removeEntry(ab);
                    break;
                case 'c':
                    findEntry(ab);
                    break;
                case 'd':
                    ab.list();
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }

            selection = Menu.prompt_Menu();
        }

        if (selection == 'e') {
            System.out.println("Goodbye!");
        }
    }

    private static void findEntry(AddressBook ab) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter in all or the beginning of the Last Name of the contact you wish to find:");
        System.out.print("> ");
        String lastName = input.nextLine();
        ArrayList<AddressEntry> result = ab.find(lastName);

        if (result.size() > 0) {
            System.out.println("The following " + result.size() + " entries were found in the address book for a last name starting with " + lastName);
            for (int i = 0; i < result.size(); i++) {
                System.out.println(i+1 + ": " + result.get(i).toString());
            }
        } else {
            System.out.println("No entries found.");
        }
    }

    private static void removeEntry(AddressBook ab) {
        Scanner input = new Scanner(System.in);
        int selection;
        char isRemove;
        System.out.println("Enter in Last Name of contact to remove:");
        System.out.print("> ");
        String lastName = input.nextLine();
        ArrayList<AddressEntry> result = ab.find(lastName);

        if (result.size() <= 0) {
            System.out.println("No entries found");
            return;
        }

        System.out.println("The following " + result.size() + " entries were found in the address book");
        System.out.println("Select number of entry you wish to remove:");

        for (int i = 1; i <= result.size(); i++) {
            System.out.print(i + ": ");
            System.out.println(result.get(i-1));
        }

        System.out.print("> ");
        selection = Integer.parseInt(input.nextLine());

        while (selection <= 0 || selection > result.size()) {
            System.out.println("Invalid selection. Please try again");
            System.out.print("> ");
            selection = Integer.parseInt(input.nextLine());
        };

        System.out.println("Hit y to remove the following entry or n to return to main menu:");
        System.out.println(result.get(selection-1));
        System.out.print("> ");
        isRemove = input.next().charAt(0);

        if (isRemove == 'y') {
            AddressEntry contact = result.get(selection-1);
            ab.remove(contact);
            System.out.println("You have successfully removed the " + contact.getName() + " contact");
        }
    }

    private static void addEntry(AddressBook ab) {
        AddressEntry entry;
        String firstName;
        String lastName;
        String street;
        String city;
        String state;
        Integer zip;
        String phone;
        String email;
        int id = ab.getAddressEntryList().size();

        firstName = Menu.prompt_FirstName();

        lastName = Menu.prompt_LastName();

        street = Menu.prompt_Street();

        city = Menu.prompt_City();

        state = Menu.prompt_State();

        zip = Menu.prompt_Zip();

        phone = Menu.prompt_Telephone();

        email = Menu.prompt_Email();

        entry = new AddressEntry(id, firstName, lastName, street, city, state, zip, phone, email);

        ab.add(entry);

        System.out.println("Thank you! The following contact has been added to your address book: \n");
        System.out.println(entry.toString());
    }

}

