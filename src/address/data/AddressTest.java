package address.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class to test AddressTest class
 * @author Tey Jon Sornet
 * @since March 2021
 */
class AddressTest {

    /**
     * 1st test for setStreet method
     */
    @Test
    void test1SetStreet() {
        Address address = new Address();
        String street1 = "Main St";
        address.setStreet(street1);
        assertEquals(address.getStreet(), street1);
    }

    /**
     * 2nd test for setStreet method
     */
    @Test
    void test2SetStreet() {
        Address address = new Address();
        String street2 = "Hesperian Blvd";
        address.setStreet(street2);
        assertEquals(address.getStreet(), street2);
    }

    /**
     * 1st test for getStreet method
     */
    @Test
    void test1GetStreet() {
        Address address = new Address("Mission Blvd", "Hayward", "CA", 94544);
        assertEquals(address.getStreet(), "Mission Blvd");
    }

    /**
     * 2nd test for getStreet method
     */
    @Test
    void test2GetStreet() {
        Address address = new Address("Carlos Bee", "Hayward", "CA", 94544);
        assertEquals(address.getStreet(), "Carlos Bee");
    }

    /**
     * 1st test for setCity method
     */
    @Test
    void test1SetCity() {
        Address address = new Address();
        String city1 = "Hayward";
        address.setCity(city1);
        assertEquals(address.getCity(), city1);
    }

    /**
     * 2nd test for setCity method
     */
    @Test
    void test2SetCity() {
        Address address = new Address();
        String city2 = "San Francisco";
        address.setCity(city2);
        assertEquals(address.getCity(), city2);
    }

    /**
     * 1st test for getCity method
     */
    @Test
    void test1GetCity() {
        Address address = new Address("Mission", "Hayward", "CA", 94544);
        assertEquals(address.getCity(), "Hayward");
    }

    /**
     * 2nd test for getCity method
     */
    @Test
    void test2GetCity() {
        Address address = new Address("Mission", "Chicago", "CA", 94544);
        assertEquals(address.getCity(), "Chicago");
    }

    /**
     * 1st test for setState method
     */
    @Test
    void test1SetState() {
        Address address = new Address();
        String state1 = "WY";
        address.setState(state1);
        assertEquals(address.getState(), state1);
    }

    /**
     * 2nd test for setState method
     */
    @Test
    void test2SetState() {
        Address address = new Address();
        String state2 = "GA";
        address.setState(state2);
        assertEquals(address.getState(), state2);
    }

    /**
     * 1st test for getState method
     */
    @Test
    void test1GetState() {
        Address address = new Address("Mission", "Hayward", "CA", 94544);
        assertEquals(address.getState(), "CA");
    }

    /**
     * 2nd test for getState method
     */
    @Test
    void test2GetState() {
        Address address = new Address("Mission", "Miami", "FL", 94544);
        assertEquals(address.getState(), "FL");
    }

    /**
     * 1st test for setZip method
     */
    @Test
    void test1SetZip() {
        Address address = new Address();
        int zip1 = 94544;
        address.setZip(zip1);
        assertEquals(address.getZip(), zip1);
    }

    /**
     * 2nd test for setZip method
     */
    @Test
    void test2SetZip() {
        Address address = new Address();
        int zip2 = 95035;
        address.setZip(zip2);
        assertEquals(address.getZip(), zip2);
    }

    /**
     * 1st test for getZip method
     */
    @Test
    void test1GetZip() {
        Address address = new Address("Mission Blvd", "Hayward", "CA", 94544);
        assertEquals(address.getZip(), 94544);
    }

    /**
     * 2nd test for getZip method
     */
    @Test
    void test2GetZip() {
        Address address = new Address("Mission Blvd", "Hayward", "CA", 30454);
        assertEquals(address.getZip(), 30454);
    }
}