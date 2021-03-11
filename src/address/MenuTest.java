package address;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class to test Menu class
 *
 * @author Tey Jon Sornet
 */
class MenuTest {

    /**
     * Test prompt_FirstName method to make sure return value is correct
     */
    @Test
    void testPromptFirstName() {
        String name = "James";
        ByteArrayInputStream in = new ByteArrayInputStream(name.getBytes());
        String firstName = Menu.prompt_FirstName(in);
        assertEquals(name, firstName);
    }

    /**
     * Test prompt_LastName method to make sure return value is correct
     */
    @Test
    void testPromptLastName() {
        String name = "Doe";
        ByteArrayInputStream in = new ByteArrayInputStream(name.getBytes());
        String lastName = Menu.prompt_LastName(in);
        assertEquals(name, lastName);
    }

    /**
     * Test prompt_Street method to make sure return value is correct
     */
    @Test
    void testPromptStreet() {
        String street = "Carlos Bee Blvd";
        ByteArrayInputStream in = new ByteArrayInputStream(street.getBytes());
        String streetName = Menu.prompt_Street(in);
        assertEquals(street, streetName);
    }

    /**
     * Test prompt_City method to make sure return value is correct
     */
    @Test
    void testPromptCity() {
        String city = "Hayward";
        ByteArrayInputStream in = new ByteArrayInputStream(city.getBytes());
        String cityName = Menu.prompt_City(in);
        assertEquals(city, cityName);
    }

    /**
     * Test prompt_State method to make sure return value is correct
     */
    @Test
    void testPromptState() {
        String state = "CA";
        ByteArrayInputStream in = new ByteArrayInputStream(state.getBytes());
        String stateName = Menu.prompt_State(in);
        assertEquals(state, stateName);
    }

    /**
     * Test prompt_Zip method to make sure return value is correct
     */
    @Test
    void testPromptZip() {
        String zip = "94544";
        ByteArrayInputStream in = new ByteArrayInputStream(zip.getBytes());
        Integer zipCode = Menu.prompt_Zip(in);
        assertEquals(Integer.parseInt(zip), zipCode);
    }

    /**
     * Test prompt_Telephone method to make sure return value is correct
     */
    @Test
    void testPromptTelephone() {
        String phone = "555-555-5555";
        ByteArrayInputStream in = new ByteArrayInputStream(phone.getBytes());
        String phoneNum = Menu.prompt_Telephone(in);
        assertEquals(phone, phoneNum);
    }

    /**
     * Test prompt_Email method to make sure return value is correct
     */
    @Test
    void testPromptEmail() {
        String email = "james@doe.com";
        ByteArrayInputStream in = new ByteArrayInputStream(email.getBytes());
        String emailAddress = Menu.prompt_Email(in);
        assertEquals(email, emailAddress);
    }

    /**
     * Test prompt_Menu method to make sure return value is correct
     */
    @Test
    void testPromptMenu() {
        String selection = "a";
        ByteArrayInputStream in = new ByteArrayInputStream(selection.getBytes());
        char selected = Menu.prompt_Menu(in);
        assertEquals(selection.charAt(0), selected);
    }
}