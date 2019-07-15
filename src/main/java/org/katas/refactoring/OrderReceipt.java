package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;
    private final double PERCENTAGE_TEN_DISCOUNT = 0.1;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        // print headers
        output.append("======Printing Orders======\n");

        // print  customer name and address
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());


        // print lineItems
        double totalSaleTax = 0d;
        double totalPrice = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getItemName());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.totalAmount());
            output.append('\n');

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * PERCENTAGE_TEN_DISCOUNT;
            totalSaleTax += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalPrice += lineItem.totalAmount() + salesTax;
        }

        // prints the state tax
        output.append("Sales Tax").append('\t').append(totalSaleTax);

        // print total price
        output.append("Total Price").append('\t').append(totalPrice);
        return output.toString();
    }
}