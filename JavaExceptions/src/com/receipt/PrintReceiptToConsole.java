package com.receipt;

/**
 * @PrintReceiptToConsole does all the printing regarding printing to the console
 */
public class PrintReceiptToConsole {

    /**
     * @printUserInfo prints username and phone number
     * @param userName Represents username
     * @param userPhone Represents user phone number
     */
    public static void printUserInfo(String userName, String userPhone) {
        System.out.println("Name: ................................  " + userName);
        System.out.println("Phone: ...............................  " + userPhone);

        try {
            if (userName == null || userPhone == null || userName.isEmpty() || userPhone.isEmpty()) {
                throw new IllegalArgumentException("You need to enter your details.");
            }

            if (!userName.matches("[a-zA-Z ]+")) {
                throw new IllegalArgumentException("Invalid name: Name must contain only letters and spaces.");
            }

            if (!userPhone.matches("\\d+")) {
                throw new IllegalArgumentException("Invalid phone number: Phone number must contain only numbers.");
            }

            System.out.println("Details accepted.\nName: " + userName + "\nPhone: " + userPhone);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    /**
     * Prints purchased items in a formatted way
     * @param indexes Books indices selected by user
     * @param itemNames Names of items selected by user
     * @param itemPrices Prices of items selected
     * @param totalCost The total cost of books selected
     */
    public static void printReceiptToConsole(
            int [] indexes, String[] itemNames,
            int[] itemPrices, int totalCost
    ) {
        System.out.println("Item Index" + "\t\t\t" + "Item Name" + "\t\t\t\t\t" + "Item Price");

        for (int i = 0; i < indexes.length; i++) {
            System.out.println(indexes[i] + "\t\t\t" + itemNames[i] + "\t\t\t\t\t" + itemPrices[i]);
        }
        System.out.println("Total Cost: \t\t\t\t\t\t" + "\t\t\t\t" + totalCost);

        System.out.println("Thank you. Bye!!!");
    }
}
