package address.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class to test AddressEntry class
 *
 * @author Tey Jon Sornet
 * @since March 2021
 */
class AddressEntryTest {
    @Test
    void test1SetId() {
        Name name = new Name("John", "Doe");
        Address address = new Address("123", "Milpitas", "CA", 34343);
        AddressEntry entry = new AddressEntry(0, name, address, "test@test.com", "");
        int id = 100;
        entry.setId(id);
        assertEquals(entry.getId(), id);
    }

    @Test
    void test2SetId() {
        Name name = new Name("John", "Doe");
        Address address = new Address("123", "Milpitas", "CA", 34343);
        AddressEntry entry = new AddressEntry(0, name, address, "test@test.com", "");
        int id = 200;
        entry.setId(id);
        assertEquals(entry.getId(), id);
    }

    @Test
    void test1GetId() {
        Name name = new Name("Lex", "Keaton");
        Address address = new Address("Mission Blvd", "Hayward", "CA", 94544);
        AddressEntry entry = new AddressEntry(100, name, address, "444-444-4444", "test@test.com");
        assertEquals(entry.getId(), 100);
    }

    @Test
    void test2GetId() {
        Name name = new Name("Lex", "Keaton");
        Address address = new Address("Mission Blvd", "Hayward", "CA", 94544);
        AddressEntry entry = new AddressEntry(200, name, address, "444-444-4444", "test@test.com");
        assertEquals(entry.getId(), 200);
    }

    /**
     * 1st test for setPhone method
     */
    @Test
    void test1SetPhone() {
        Name name = new Name("John", "Doe");
        Address address = new Address("123", "Milpitas", "CA", 34343);
        AddressEntry entry = new AddressEntry(100, name, address, "test@test.com", "");
        String phone1 = "510-510-4444";
        entry.setPhone(phone1);
        assertEquals(entry.getPhone(), phone1);
    }

    /**
     * 2nd test for setPhone method
     */
    @Test
    void test2SetPhone() {
        Name name = new Name("John", "Doe");
        Address address = new Address("123", "Milpitas", "CA", 34343);
        AddressEntry entry = new AddressEntry(100, name, address, "test@test.com", "");
        String phone2 = "408-408-6789";
        entry.setPhone(phone2);
        assertEquals(entry.getPhone(), phone2);
    }

    /**
     * 1st test for getPhone method
     */
    @Test
    void test1GetPhone() {
        Name name = new Name("Lex", "Keaton");
        Address address = new Address("Mission Blvd", "Hayward", "CA", 94544);
        AddressEntry entry = new AddressEntry(100, name, address, "444-444-4444", "test@test.com");
        assertEquals(entry.getPhone(), "444-444-4444");
    }

    /**
     * 2nd test for getPhone method
     */
    @Test
    void test2GetPhone() {
        Name name = new Name("Lex", "Keaton");
        Address address = new Address("Mission Blvd", "Hayward", "CA", 94544);
        AddressEntry entry = new AddressEntry(100, name, address, "343-343-2312", "test@test.com");
        assertEquals(entry.getPhone(), "343-343-2312");
    }

    /**
     * 1st test for setEmail method
     */
    @Test
    void test1SetEmail() {
        Name name = new Name("John", "Doe");
        Address address = new Address("123", "Milpitas", "CA", 34343);
        AddressEntry entry = new AddressEntry(100, name, address, "", "333-333-3333");
        String email1 = "test@test.com";
        entry.setEmail(email1);
        assertEquals(entry.getEmail(), email1);
    }

    /**
     * 2nd test for setEmail method
     */
    @Test
    void test2SetEmail() {
        Name name = new Name("John", "Doe");
        Address address = new Address("123", "Milpitas", "CA", 34343);
        AddressEntry entry = new AddressEntry(100, name, address, "", "444-444-4444");
        String email2 = "john@doe.com";
        entry.setEmail(email2);
        assertEquals(entry.getEmail(), email2);
    }

    /**
     * 1st test for getEmail method
     */
    @Test
    void test1GetEmail() {
        Name name = new Name("Lex", "Keaton");
        Address address = new Address("Mission Blvd", "Hayward", "CA", 94544);
        AddressEntry entry = new AddressEntry(100, name, address, "343-343-2312", "test@test.com");
        assertEquals(entry.getEmail(), "test@test.com");
    }

    /**
     * 2nd test for getEmail method
     */
    @Test
    void test2GetEmail() {
        Name name = new Name("Lex", "Keaton");
        Address address = new Address("Mission Blvd", "Hayward", "CA", 94544);
        AddressEntry entry = new AddressEntry(100, name, address, "343-343-2312", "lex@keaton.com");
        assertEquals(entry.getEmail(), "lex@keaton.com");
    }
}