package lewis.edu.cafe.model; 
// package = folder where this file lives. 
// "lewis.edu.cafe.model" keeps our project organized.

// We use BigDecimal for money instead of double because its more accurate for currency
import java.math.BigDecimal;

/**
 * Product is the base class for all items sold in the cafe.
 * It is marked "abstract" because we won't create plain Products,
 * only specific ones like Beverages or Food that extend it.
 */
public abstract class Product {
    //  Private fields = (data hiding)
    private String id;          // Example: "B1" for a beverage
    private String name;        // Example: "Latte"
    private BigDecimal basePrice; // Example: 2.50

    /**
     * Constructor = runs when we create a new object.
     * Forces every Product to have an id, name, and base price.
     */
    public Product(String id, String name, BigDecimal basePrice) {
        setId(id);           // use setter for validation
        setName(name);
        setBasePrice(basePrice);
    }

    // Getters and  Setters 

    // Getter for id
    public String getId() {
        return id;
    }

    // Setter for id (with validation)
    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty");
        }
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name (with validation)
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    // Getter for basePrice
    public BigDecimal getBasePrice() {
        return basePrice;
    }

    // Setter for basePrice (with validation)
    public void setBasePrice(BigDecimal basePrice) {
        if (basePrice == null || basePrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price must be >= 0");
        }
        this.basePrice = basePrice;
    }

    

    /**
     * Returns a display name for menus.
     * Example: "Latte ($2.50)"
     */
    public String getDisplayName() {
        return name + " ($" + basePrice + ")";
    }

    /**
     * Abstract method = subclasses (like Beverage or Food) 
     * MUST provide their own version of price().
     * Example: Beverage will calculate price with size multiplier.
     */
    public abstract BigDecimal price();
}
