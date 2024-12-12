package com.item;

/**
 * Item class defines handout name and price
 */
public class Item {
    String handoutName;
    int price;

    /**
     * This is the Item constructor.
     * @param handoutName This represents the name of book
     * @param price This represents the price of pook
     */
    public Item(String handoutName, int price) {
        this.handoutName = handoutName;
        this.price = price;
    }

    /**
     * @getHandoutName method return the name of the handout.
     * @return the name of handout
     */
    public String getHandoutName() {
        return this.handoutName;
    }

    /**
     * @getPrice method returns the price of the handout.
     * @return the price of handout
     */
    public int getPrice() {
        return this.price;
    }
}
