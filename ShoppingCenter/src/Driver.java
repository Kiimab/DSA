import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
        static boolean run = true; // Easy way to end the main menu loop.
        static Scanner sc = new Scanner(System.in); // Creates scanner object for user input.

        public static void main(String args[]) {
                System.out.println("Before beginning, please add items to the Shopping Center.");

                Item.CreateItems();

                System.out.println("********************");
                System.out.println("Welcome to the Shopping Center!");
                System.out.println("********************");

                while (run == true)
                        try {
                                System.out.println("\n0. Close the Shopping Center.");
                                System.out.println("1. Customer enters Shopping Center.");
                                System.out.println("2. Customer picks an item and places it in the shopping cart.");
                                System.out.println("3. Customer removes an item from the shopping cart.");
                                System.out.println("4. Customer is done shopping.");
                                System.out.println("5. Customer checks out.");
                                System.out.println("6. Print info about customers who are shopping.");
                                System.out.println("7. Print info about customers in checkout lines.");
                                System.out.println("8. Print info about items at or below re-stocking level.");
                                System.out.println("9. Reorder an item.");
                                int choice = sc.nextInt();
                                switch (choice) {
                                case 0:
                                        run = false;
                                        break;
                                case 1:
                                        Customer.CreateCustomers();
                                        break;
                                case 2:
                                        // Customer picks an item and places it in the shopping cart.
                                        Customer.AddToCart();
                                        break;
                                case 3:
                                        // Customer removes an item from the shopping cart.
                                        Customer.RemoveFromCart();
                                        break;
                                case 4:
                                        //  Customer is done shopping.
                                        ShoppingCenter.AddCustomerToCheckout();
                                        break;
                                case 5:
                                        //  Customer checks out.
                                        ShoppingCenter.CustomerCheckout();
                                        break;
                                case 6:
                                        // Print info about customers who are shopping.
                                        ShoppingCenter.PrintCustomersShopping();
                                        break;
                                case 7:
                                        //  Print info about customers in checkout lines.
                                        ShoppingCenter.PrintCustomersInCheckout();
                                        break;
                                case 8:
                                        //  Print info about items at or below re-stocking level.
                                        ShoppingCenter.PrintInventory();
                                        break;
                                case 9:
                                        //  Reorder an item.
                                        Item.Reorder();
                                        break;
                                default:
                                        // Default.
                                        System.out.println("Please enter a valid input.");
                                        break;
                                }
                        } catch (InputMismatchException e) {
                                System.out.println("Please enter a valid input.");
                        }
        }
}
