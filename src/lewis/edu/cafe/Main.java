package lewis.edu.cafe;  
// This is the main package where the app starts.

import java.util.Scanner;  
// Scanner lets us read input from the keyboard.

import lewis.edu.cafe.data.Menu;  
import lewis.edu.cafe.model.Order;  
import lewis.edu.cafe.model.Product;

/**
 * Main class = entry point of the program.
 */
public class Main {

    public static void main(String[] args) {
        // Make a Scanner to read input
        Scanner scanner = new Scanner(System.in);

        // Make a Menu and an empty Order
        Menu menu = new Menu();
        Order order = new Order();

        System.out.println("Welcome to the Campus Cafe!");

        boolean running = true; // loop until user quits

        while (running) {
            // Show the menu
            menu.printMenu();

            System.out.println("Enter item number to add, or 0 to finish: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                // User is done ordering
                running = false;
            } else {
                try {
                    // Get product from menu
                    Product product = menu.getProductByNumber(choice);

                    System.out.println("Enter quantity: ");
                    int qty = scanner.nextInt();

                    // Add product to order
                    order.addItem(product, qty);

                    System.out.println("Added " + qty + " x " + product.getName());
                } catch (Exception e) {
                    // If invalid number, show message
                    System.out.println("Invalid choice, try again.");
                }
            }
        }

        // Print final receipt
        order.printReceipt();

        // Close scanner
        scanner.close();
    }
}
