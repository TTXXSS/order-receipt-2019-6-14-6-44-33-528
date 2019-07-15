package org.katas.refactoring;

public class LineItem {
    private String itemName;
    private double price;
    private int quantity;

    public LineItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {

        return itemName;
    }

    public double getPrice() {

        return price;
    }

    public int getQuantity() {

        return quantity;
    }

    double totalAmount() {

        return price * quantity;
    }
}