package com.handout;

import com.item.Item;

/**
 * @Handout class contains methods for purchasing handouts
 */
public class Handout {
    /**
     * @printInventory prints items listed in inventory method to the console
     * @inventory
     */
    public static void printInventory (Item[] inventory) {
        System.out.println("Select books from the inventory: ");

        for (int i = 0; i < inventory.length; i++) {
            System.out.println(i + ":  " + inventory[i].getHandoutName() + "\t" + inventory[i].getPrice());
        }
    }

    /**
     * @takeUserInput alerts, takes user input and stores it.
     * @return an array used as indexes from user
     */
    public static int[] takeUserInput(String[] tokens) {
        // Convert tokens from a string type to an integer type
        int[] indexes = new int[tokens.length];

        for (int i = 0; i < indexes.length; i++) {
            try {
                indexes[i] = Integer.parseInt(tokens[i].trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + tokens[i] + " is not a valid number.");
                indexes[i] = -1;
            }
        }
        return indexes;
    }

    /**
     * @getItemNamesFromIventory loops through the inventory and stores the names books selected by the user.
     *
     * @return an array of the names fo books selected by the user
     */
    public static String[] getItemNamesFromInventory(int[] itemIndexes, Item[] inventoryItems) {
        String[] itemNames = new String[itemIndexes.length];

        for (int i = 0; i < itemIndexes.length; i++) {
            try {
                itemNames[i] = inventoryItems[itemIndexes[i]].getHandoutName();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid item index: " + itemIndexes[i] + " is not in the inventory.");
                itemNames[i] = "Unknown Item";
            }
        }
        return itemNames;
    }


    /**
     * @getItemNamesFromIventory stores the prices of each item in an array
     * @return an array for each corresponding book.
     */
    public static int[] getItemPricesFromInventory(int[] itemIndexes, Item[] inventoryItems) {
        int[] itemPrices = new int[itemIndexes.length];

        for (int i = 0; i < itemIndexes.length; i++) {
            try {
                itemPrices[i] = inventoryItems[itemIndexes[i]].getPrice();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid item index: " + itemIndexes[i] + " is not in the inventory.");
                itemPrices[i] = 0;
            }
        }
        return itemPrices;
    }

    /**
     * @calTotalPriceOfItems computes the total cost of books selected from inventory
     * @return the total price of items bought
     */
    public static int calTotalPriceOfItems(int[] itemPrices) {
        int totalPrice = 0;
        for (int price: itemPrices) {
            totalPrice += price;
        }
        return totalPrice;
    }
}
