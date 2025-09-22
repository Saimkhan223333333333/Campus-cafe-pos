package lewis.edu.cafe.model;  
// This tells Java the folder where this file lives.
// Must match the folder path in Eclipse.

/**
 * Size is an enum (special type in Java) for fixed choices.
 * Our choices are SMALL, MEDIUM, LARGE.
 * Each size has a multiplier that changes the price.
 */
public enum Size {  
    SMALL(1.0),   // Small = 100% of the base price
    MEDIUM(1.2),  // Medium = 120% of the base price
    LARGE(1.5);   // Large = 150% of the base price

    private final double multiplier;  
    // This number tells us how much to multiply the base price by.
    // Example: MEDIUM = basePrice * 1.2

    // Constructor for each enum option
    Size(double multiplier) {
        this.multiplier = multiplier;  
        // Save the multiplier value into the field above.
    }

    // Getter method to read the multiplier
    public double getMultiplier() {
        return multiplier;  
        // Returns the number, like 1.0, 1.2, or 1.5
    }
}

