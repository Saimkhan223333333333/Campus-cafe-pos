package lewis.edu.cafe.data;  
// This package is for data classes (like Menu).

import java.math.BigDecimal;  
import java.util.ArrayList;  
import java.util.List;  

import lewis.edu.cafe.model.*;  
// Import everything from model (Product, Beverage, Food, Size).

/**
 * Menu holds a list of products available at the cafe.
 */
public class Menu {

    // ======== Fields ========
    private List<Product> products;  
    // A list to hold all the menu items.

    // ======== Constructor ========
    public Menu() {
        products = new ArrayList<>();  
        // Start with an empty list.
        loadMenu();  
        // Fill the list with items.
    }

    // ======== Load Menu Method ========
    private void loadMenu() {
        // Add some drinks
        products.add(new Beverage("B1", "Latte", BigDecimal.valueOf(2.50), Size.SMALL));
        products.add(new Beverage("B2", "Latte", BigDecimal.valueOf(2.50), Size.MEDIUM));
        products.add(new Beverage("B3", "Latte", BigDecimal.valueOf(2.50), Size.LARGE));

        // Add some food
        products.add(new Food("F1", "Sandwich", BigDecimal.valueOf(4.00), false));
        products.add(new Food("F2", "Sandwich", BigDecimal.valueOf(4.00), true));
    }

    // ======== Get All Products ========
    public List<Product> getProducts() {
        return products;  
    }

    // ======== Print Menu ========
    public void printMenu() {
        System.out.println("===== Cafe Menu =====");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println((i + 1) + ". " + p.getDisplayName());
        }
        System.out.println("=====================");
    }

    // ======== Get Product by Number ========
    public Product getProductByNumber(int number) {
        if (number <= 0 || number > products.size()) {
            throw new IllegalArgumentException("Invalid product number");
        }
        return products.get(number - 1);
    }
}
