package lewis.edu.cafe.model;  
// Same package as Product, Beverage, Food, LineItem.

import java.math.BigDecimal;  
import java.util.ArrayList;  
import java.util.List;  
// We need ArrayList and List to hold many LineItems.

/**
 * Order represents a full customer order.
 * It holds multiple LineItems and calculates totals.
 */
public class Order {

    // ======== Fields ========
    private List<LineItem> items;  
    // A list (like a box) that stores many line items.
    private static final BigDecimal TAX_RATE = BigDecimal.valueOf(0.07);  
    // Tax is 7% (you can change this later).

    // ======== Constructor ========
    public Order() {
        items = new ArrayList<>();  
        // Start with an empty list of items.
    }

    // ======== Add Item Method ========
    public void addItem(Product product, int quantity) {
        // Add a new LineItem to the list.
        LineItem item = new LineItem(product, quantity);  
        items.add(item);
    }

    // ======== Subtotal Method ========
    public BigDecimal subtotal() {
        BigDecimal subtotal = BigDecimal.ZERO;  
        // Start at 0.

        // Go through every item and add up their totals.
        for (LineItem item : items) {
            subtotal = subtotal.add(item.lineTotal());
        }

        return subtotal;  
    }

    // ======== Tax Method ========
    public BigDecimal tax() {
        // tax = subtotal * TAX_RATE
        return subtotal().multiply(TAX_RATE);
    }

    // ======== Total Method ========
    public BigDecimal total() {
        // total = subtotal + tax
        return subtotal().add(tax());
    }

    // ======== Print Receipt ========
    public void printReceipt() {
        System.out.println("===== Receipt =====");
        for (LineItem item : items) {
            System.out.println(item.getDisplayName());
        }
        System.out.println("-------------------");
        System.out.println("Subtotal: $" + subtotal());
        System.out.println("Tax: $" + tax());
        System.out.println("Total: $" + total());
        System.out.println("===================");
    }
}
