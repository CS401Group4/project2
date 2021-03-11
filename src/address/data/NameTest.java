package address.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class to test Name class
 * @author Tey Jon Sornet
 * @since March 2021
 */
class NameTest {

    /**
     * 1st test for setFirstName method in Name
     */
    @Test
    void test1SetFirstName() {
        Name name = new Name();
        String name1 = "John";
        name.setFirstName(name1);
        assertEquals(name.getFirstName(), name1);
    }

    /**
     * 2nd test for setFirstName method in Name
     */
    @Test
    void test2SetFirstName() {
        Name name = new Name();
        String name1 = "James";
        name.setFirstName(name1);
        assertEquals(name.getFirstName(), name1);
    }

    /**
     * 1st test for getFirstName method in Name
     */
    @Test
    void test1GetFirstName() {
        Name name = new Name("John", "Doe");
        assertEquals(name.getFirstName(), "John");
    }

    /**
     * 2nd test for getFirstName method in Name
     */
    @Test
    void test2GetFirstName() {
        Name name = new Name("Lex", "Doe");
        assertEquals(name.getFirstName(), "Lex");
    }

    /**
     * 1st test for setLastName method in Name
     */
    @Test
    void test1SetLastName() {
        Name name = new Name();
        String name1 = "Doe";
        name.setLastName(name1);
        assertEquals(name.getLastName(), name1);
    }

    /**
     * 2nd test for setLastName method in Name
     */
    @Test
    void test2SetLastName() {
        Name name = new Name();
        String name1 = "Keaton";
        name.setLastName(name1);
        assertEquals(name.getLastName(), name1);
    }

    /**
     * 1st test for getLastName method in Name
     */
    @Test
    void test1GetLastName() {
        Name name = new Name("Lex", "Doe");
        assertEquals(name.getLastName(), "Doe");
    }

    /**
     * 2nd test for getLastName method in Name
     */
    @Test
    void test2GetLastName() {
        Name name = new Name("Lex", "Keaton");
        assertEquals(name.getLastName(), "Keaton");
    }
}