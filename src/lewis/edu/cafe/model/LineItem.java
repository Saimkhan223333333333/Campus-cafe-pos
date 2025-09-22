package lewis.edu.cafe.model;  
// Same package as the other model classes.

import java.math.BigDecimal;  
// We use BigDecimal for money math.

/**
 * LineItem represents one product in an order
 * with its quantity (like 2 lattes).
 */
public final class LineItem {  
    // "final" means no one can extend this class (it’s the last level).

    // ======== Fields ========
    private Product product;  
    // The product (Beverage or Food).
    private int quantity;     
    // How many of that product.

    // ======== Constructor ========
    public LineItem(Product product, int quantity) {
        setProduct(product);   // Set product using setter.
        setQuantity(quantity); // Set quantity using setter.
    }

    // ======== Getter/Setter for Product ========
    public Product getProduct() {
        return product;  
    }

    public void setProduct(Product product) {
        if (product == null) {  
            // Make sure product is not empty.
            throw new IllegalArgumentException("Product cannot be null");
        }
        this.product = product;
    }

    // ======== Getter/Setter for Quantity ========
    public int getQuantity() {
        return quantity;  
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {  
            // Quantity must be at least 1.
            throw new IllegalArgumentException("Quantity must be > 0");
        }
        this.quantity = quantity;
    }

    // ======== Method to get line total ========
    public BigDecimal lineTotal() {
        // line total = product price * quantity
        return product.price().multiply(BigDecimal.valueOf(quantity));
    }

    // ======== Display Name ========
    public String getDisplayName() {
        // Example: "2 x Latte (MEDIUM) - $6.00"
        return quantity + " x " + product.getDisplayName() + " = $" + lineTotal();
    }
}
