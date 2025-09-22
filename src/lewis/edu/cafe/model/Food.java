package lewis.edu.cafe.model;  
// Keep it in the same package as Product, Size, Beverage.

import java.math.BigDecimal;  
// BigDecimal is for money math (avoids rounding errors).

/**
 * Food is another child of Product.
 * It can have an optional add-on (like extra cheese) that changes the price.
 */
public class Food extends Product {  
    // Food "extends Product" → it is a type of Product.

    // ======== Field ========
    private boolean extraCheese;  
    // true = has extra cheese, false = no extra cheese.

    // ======== Constructor ========
    public Food(String id, String name, BigDecimal basePrice, boolean extraCheese) {
        super(id, name, basePrice);  
        // Call parent constructor to set id, name, base price.
        setExtraCheese(extraCheese);  
        // Set the add-on using setter.
    }

    // ======== Getter ========
    public boolean hasExtraCheese() {  
        return extraCheese;  
        // Return true or false depending if extra cheese is added.
    }

    // ======== Setter ========
    public void setExtraCheese(boolean extraCheese) {  
        this.extraCheese = extraCheese;  
        // Just set the value (no validation needed here).
    }

    // ======== Price Method ========
    @Override
    public BigDecimal price() {
        // Start with the base price
        BigDecimal finalPrice = getBasePrice();

        // If extra cheese is true, add $1.00
        if (extraCheese) {
            finalPrice = finalPrice.add(BigDecimal.valueOf(1.00));
        }

        return finalPrice;  
        // Return the final calculated price
    }

    // ======== Display Name ========
    @Override
    public String getDisplayName() {
        // Show name + (Extra Cheese) if true + base price
        if (extraCheese) {
            return getName() + " (Extra Cheese) - $" + getBasePrice();
        } else {
            return getName() + " - $" + getBasePrice();
        }
    }
}
