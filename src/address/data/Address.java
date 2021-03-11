package address.data;

/**
 * Class to create instance of user's Address
 * @author Tey Jon Sornet
 * @since February 2021
 */
public class Address {
    /**
     * Street address of user
     */
    private String street;

    /**
     * City name of user
     */
    private String city;

    /**
     * State of user
     */
    private String state;

    /**
     * Zip code of user
     */
    private int zip;

    /**
     * Default constructor
     */
    public Address() {}

    /**
     * Custom constructor which takes in street, city, state and zip values
     * @param street String containing user's street name
     * @param city String containing user's city name
     * @param state String containing user's state
     * @param zip int containing user's zip code
     */
    public Address(String street, String city, String state, int zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    /**
     * Method to set street name
     * @param street String of street name
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Method to get street name
     * @return String containing street name
     */
    public String getStreet() {
        return street;
    }

    /**
     * Method to set city name
     * @param city String of city name
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Method to get city name
     * @return String containing city name value
     */
    public String getCity() {
        return city;
    }

    /**
     * Method to set state
     * @param state String of state value
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Method to get state
     * @return String containing state value
     */
    public String getState() {
        return state;
    }

    /**
     * Method to set zip code
     * @param zip integer of zip code value
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     * Method to get zip code
     * @return integer containing zip code
     */
    public Integer getZip() {
        return zip;
    }

    /**
     * Method that overrides toString
     * @return String containing Address object values
     */
    @Override
    public String toString() {
        return street + "\n" +
                city + ", " + state + " " + zip + "\n";
    }
}
