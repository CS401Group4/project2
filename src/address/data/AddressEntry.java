package address.data;

/**
 * Represents a single object entry in the AddressBook class
 * Overrides a toString() method that prints out all the data in an entry
 * @author Tey Jon Sornet
 * @since February 2021
 */
public class AddressEntry {
    /**
     * Integer of AddressEntry entry
     */
    private Integer id;

    /**
     * String containing phone value
     */
    private String phone;

    /**
     * String containing email value
     */
    private String email;

    /**
     * String containing name value
     */
    private Name name;

    /**
     * Address object containing street, city, state and zip values
     */
    private Address address;

    /**
     * Custom constructor
     * @param id integer representing an id
     * @param name Name object containing user's first and last name
     * @param address Address object containing user's street, city, state and zip values
     * @param email String containing user's email
     * @param phone String containing user's phone
     */
    public AddressEntry(int id, Name name, Address address, String email, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    /**
     * Custom constructor
     * @param id integer representing id
     * @param firstName String containing user's first name
     * @param lastName String containing user's last name
     * @param street String containing user's street value
     * @param city String containing user's city value
     * @param state String containing user's state value
     * @param zip int containing user's zip code value
     * @param phone String containing user's phone value
     * @param email String containing user's email value
     */
    public AddressEntry(int id, String firstName, String lastName, String street, String city, String state, int zip, String phone, String email) {
        this.id = id;
        this.name = new Name(firstName, lastName);
        this.address = new Address(street, city, state, zip);
        this.phone = phone;
        this.email = email;
    }

    /**
     * Method that overrides default toString method
     * @return
     */
    @Override
    public String toString() {
        return name.toString() +
                address.toString() +
                email + "\n" +
                phone + "\n";
    }

    /**
     * Method to set id
     * @param id integer representing id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Method to get id
     * @return integer containing AddressEntry's id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Method to  set phone number
     * @param phone String containing phone value
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Method to get phone number
     * @return String containing phone value
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Method to set email
     * @param email String containing email value
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method to get email
     * @return String containing email value
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method to get Name object
     * @return Name object containing first and last name
     */
    public Name getName() {
        return name;
    }

    /**
     * Method to get user's last name
     * @return String containing user's last name
     */
    public String getLastName() { return name.getLastName(); }

    /**
     * Method to get Address object
     * @return Address object containing street, city, state and zip values
     */
    public Address getAddress() { return address; }
}

