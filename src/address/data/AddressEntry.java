package address.data;

/**
 * Represents a single object entry in the AddressBook class
 * Overrides a toString() method that prints out all the data in an entry
 */
public class AddressEntry {
    private Integer id;
    private String phone;
    private String email;
    private Name name;
    private Address address;

    // Constructors
    public AddressEntry(int id, Name name, Address address, String email, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public AddressEntry(int id, String firstName, String lastName, String street, String city, String state, int zip, String phone, String email) {
        this.id = id;
        this.name = new Name(firstName, lastName);
        this.address = new Address(street, city, state, zip);
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return name.toString() +
                address.toString() +
                email + "\n" +
                phone + "\n";
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Name getName() {
        return name;
    }
}

