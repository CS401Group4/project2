package address.data;

/**
 * Class to set a Name object with user's first and last name
 * @author Tey Jon Sornet
 * @since February 2021
 */
public class Name {
    /**
     * First name
     */
    private String firstName;

    /**
     * Last name
     */
    private String lastName;

    /**
     * Default constructor
     */
    public Name() {}

    /**
     * Custom constructor initializing first and last name
     * @param firstName String first name
     * @param lastName String last name
     */
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Method to set first name
     * @param firstName String first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Method to get first name
     * @return String first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method to set last name
     * @param lastName String last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Method to get last name
     * @return String last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method to override toString
     * @return String containing first and last name
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + "\n";
    }
}
