package lewis.edu.cafe.model;  
// This file belongs in the same package as Product and Size.

/**
 * Beverage is a child of Product.
 * It adds a Size (SMALL, MEDIUM, LARGE) that changes the final price.
 */
import java.math.BigDecimal; // We need BigDecimal for money math.

public class Beverage extends Product {  
    // "extends Product" = Beverage inherits from Product.

    // ======== Field ========
    private Size size;  
    // Every Beverage has a Size (SMALL, MEDIUM, LARGE).

    // ======== Constructor ========
    public Beverage(String id, String name, BigDecimal basePrice, Size size) {
        super(id, name, basePrice);  
        // Call the parent (Product) constructor for id, name, basePrice.
        setSize(size);  
        // Set the size using the setter (with safety check).
    }

    // ======== Getter ========
    public Size getSize() {  
        return size;  // return the drink’s size
    }

    // ======== Setter ========
    public void setSize(Size size) {  
        if (size == null) {  
            // Make sure size isn’t empty.
            throw new IllegalArgumentException("Size cannot be null");
        }
        this.size = size;  
        // Save the size into the field above.
    }

    // ======== Price Method ========
    @Override  
    // We must write our own version of price(), since Product is abstract.
    public BigDecimal price() {
        // Multiply base price by the size multiplier.
        return getBasePrice().multiply(BigDecimal.valueOf(size.getMultiplier()));
        // Example: basePrice = 2.50, MEDIUM multiplier = 1.2 → 3.00
    }

    // ======== Display Name ========
    @Override
    public String getDisplayName() {
        // Show the name, size, and base price.
        return getName() + " (" + size + ") - $" + getBasePrice();
    }
}
