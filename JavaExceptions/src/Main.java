import com.handout.Handout;
import com.item.Item;
import com.receipt.PrintReceiptToConsole;

import java.util.Scanner;

/**
 * Prints receipt to console after alerting user to select items for purchasing
 */
public class Main {
    public static void main(String[] args) {
        // Scanner class takes inputs from users in the console
        Scanner input = new Scanner(System.in);

        // Inventory to be used
        Item[] inventory = {
                new Item("DATA STRUCTURES AND ALGORITHMS", 40),
                new Item("DATA COMMUNICATION TECH AND TELECOM TECH", 45),
                new Item("SOFTWARE DEVELOPMENT JAVA", 45),
                new Item("OPERATING SYSTEMS", 37),
                new Item("WEB DEVELOPMENT TECH", 45),
                new Item("DATABASE CONCEPT AND TECH", 50),
                new Item("SYSTEM ANALYSIS AND DESIGN", 45),
                new Item("ASSESSMENT BOOK", 30)
        };

        Handout.printInventory(inventory);

        // Get username and check if it's letters
        System.out.println("Enter your name: ................");
        String userName = input.nextLine();
        try {
            if (userName == null || userName.isEmpty()) {
                throw new IllegalArgumentException("You need to enter your details.");
            }

            if (!userName.matches("[a-zA-Z ]+")) {
                throw new IllegalArgumentException("Invalid name: Name must contain only letters and spaces.");
            }

            System.out.println("Details accepted.\nName: " + userName );
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Details rejected.\nName: " + userName );
            System.exit(-1);
        }

        // Get user phone and check if it's an integer
        System.out.println("Enter your phone number: ......................");
        String userPhone = input.nextLine();
        try {
            if (userPhone == null || userPhone.isEmpty()) {
                throw new IllegalArgumentException("You need to enter your details.");
            }

            if (!userPhone.matches("\\d+")) {
                throw new IllegalArgumentException("Invalid phone number: Phone number must contain only numbers.");
            }

            System.out.println("Details accepted.\nPhone: " + userPhone);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Details rejected.\nPhone: " + userPhone);
            System.exit(-1);
        }

        // Alert and get user indices
        System.out.println("\nType in the indexes of the Books you want... ");
        String[] tokens = input.nextLine().split(" ");


        // Indices of items selected by user from inventory
        int[] userSelectedIndexes = Handout.takeUserInput(tokens);

        // Gets books from inventory using the indices from user
        String[] booksSelected = Handout.getItemNamesFromInventory(userSelectedIndexes, inventory);

        // Gets the prices from inventory
        int[] booksSelectedPrices = Handout.getItemPricesFromInventory(userSelectedIndexes, inventory);

        // Computes total cost of books selected from inventory
        int totalCost = Handout.calTotalPriceOfItems(booksSelectedPrices);

        // Prints user details
        PrintReceiptToConsole.printUserInfo(userName, userPhone);

        // Prints receipt
        PrintReceiptToConsole.printReceiptToConsole(
                userSelectedIndexes, booksSelected,
                booksSelectedPrices, totalCost
        );
    }
}