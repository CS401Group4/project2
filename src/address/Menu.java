package address;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Class that prompts user to enter data
 *
 * @author Tey Jon Sornet
 * @since February 2021
 */
public class Menu {
    /**
     * Method to prompt first name
     * @return String first name
     */
    public static String prompt_FirstName(InputStream in) {
        Scanner input = new Scanner(in);
        System.out.println("First Name:");
        System.out.print("> ");
        return input.nextLine();
    }

    /**
     * Method to prompt last name
     * @return String last name
     */
    public static String prompt_LastName(InputStream in) {
        Scanner input = new Scanner(in);
        System.out.println("Last Name:");
        System.out.print("> ");
        return input.nextLine();
    }

    /**
     * Method to prompt street name
     * @return String street name
     */
    public static String prompt_Street(InputStream in) {
        Scanner input = new Scanner(in);
        System.out.println("Street:");
        System.out.print("> ");
        return input.nextLine();
    }

    /**
     * Method to prompt city name
     * @return String city name
     */
    public static String prompt_City(InputStream in) {
        Scanner input = new Scanner(in);
        System.out.println("City:");
        System.out.print("> ");
        return input.nextLine();
    }

    /**
     * Method to prompt state
     * @return String state
     */
    public static String prompt_State(InputStream in) {
        Scanner input = new Scanner(in);
        System.out.println("State:");
        System.out.print("> ");
        return input.nextLine();
    }

    /**
     * Method to prompt zip code
     * @return int zip code
     */
    public static int prompt_Zip(InputStream in) {
        Scanner input = new Scanner(in);
        System.out.println("Zip:");
        System.out.print("> ");
        return Integer.parseInt(input.nextLine());
    }

    /**
     * Method to prompt telephone number
     * @return String telephone
     */
    public static String prompt_Telephone(InputStream in) {
        Scanner input = new Scanner(in);
        System.out.println("Telephone:");
        System.out.print("> ");
        return input.nextLine();
    }

    /**
     * Method to prompt email
     * @return String email
     */
    public static String prompt_Email(InputStream in) {
        Scanner input = new Scanner(in);
        System.out.println("Email:");
        System.out.print("> ");
        return input.nextLine();
    }

    /**
     * Method to prompt menu selection
     * @return char input selection
     */
    public static char prompt_Menu(InputStream in) {
        Scanner input = new Scanner(in);
        System.out.println("******************");
        System.out.println("Please enter in your menu selection");
        System.out.println("a) Addition");
        System.out.println("b) Removal");
        System.out.println("c) Find");
        System.out.println("d) Listing");
        System.out.println("e) Quit");
        System.out.println("******************");
        System.out.print("> ");
        return input.nextLine().charAt(0);
    }
}
