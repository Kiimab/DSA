import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
	public static void main(String args[]) {
		boolean run = true; // Easy way to end the main menu loop.
		Scanner sc = new Scanner(System.in); // Creates scanner object for user input.
		ShoppingCenter shoppingCenter = new ShoppingCenter();

		System.out.println("Before beginning, please add items to the Shopping Center.");

		boolean addItems = true;
		int ask = 0; // Amount of times user was asked to enter items.
		while (addItems == true) {
			String item = "";
			int amount = 0;
			System.out.print("\nName of item: ");
			if (ask >= 1) {
				System.out.println("\nOr enter 'Done' when complete. ");
			}
			item = sc.next();
			if (!item.equalsIgnoreCase("Done")) {
				System.out.print("Amount of item:");
				amount = sc.nextInt();
				shoppingCenter.addItem(item, amount);
				System.out.println(shoppingCenter.searchItem(item) + " added, with quantity of " + amount + ".");
				ask++;
			} else {
				addItems = false;
			}
		}

		System.out.println("Here is the inventory of the Shopping Center:");
		// System.out.println(test); // Testing.
		shoppingCenter.printInventory();

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
					sc.close();
					break;
				case 1:
					System.out.print("Enter name: ");
					String cust1 = sc.next();
					shoppingCenter.addCustomer(cust1, 0);
					System.out.println(cust1 + " added."); // Confirm added to shopping center.
					break;
				case 2:
					// Customer picks an item and places it in the shopping cart.
					System.out.println("Here is the customer list: ");
					shoppingCenter.printAllCustomerStillShopping();
					System.out.print("Enter customer that picked up an item: ");
					String cust2 = sc.next();
					System.out.println("Enter item that was picked up by " + cust2);
					String item2 = sc.next();
					if (shoppingCenter.equals(item2)) {
						shoppingCenter.takeItem(cust2, item2);
						System.out.println(cust2 + " has placed " + item2 + " in their cart.");
						// Confirm added to shopping center.
						// } else if (!Customer.equals(cust2)) {

					}
					break;
				case 3:
					// Customer removes an item from the shopping cart.
					System.out.print("Enter customer that removed item from cart: ");
					String cust3 = sc.next();
					System.out.println("Enter item that was removed from " + cust3 + "'s cart. ");
					String item3 = sc.next();
			//		if () { // If customer exits, and this customer's cart contains this item
			//			shoppingCenter.addToRestockList(item3); // Specify customer?
			//			System.out.println(item3 + " was removed from " + cust3 + "'s cart.");
			//		}
			//		else
			//		{
			//			System.out.println("That item does not exist.");
			//		}
					break;
				case 4:
					// Customer is done shopping.
					// ShoppingCenter.AddCustomerToCheckout();
					break;
				case 5:
					// Customer checks out.
					// The bigger the int, the longer the line.
					int expT = shoppingCenter.express.peek().getTime();
					int reg1 = shoppingCenter.regular1.peek().getTime();
					int reg2 = shoppingCenter.regular2.peek().getTime();
					int expT2 = expT * 2; // Compares to regular lines.
					if (expT2 > reg1) { // If express line is twice as long as regular 1.
						if (expT2 > reg2) { // If express line is twice as long as Regular 2.
							shoppingCenter.regular2Checkout(); // Add to Regular 2 if express is longer than 1.
						} else {
							shoppingCenter.regular1Checkout(); // Add to Regular 1 if express is shorter than regular2.
						}
					} else {
						shoppingCenter.expressCheckout(); // Add to express otherwise.
					}
					break;
				case 6:
					// Print info about customers who are shopping.
					shoppingCenter.printAllCustomerStillShopping();
					break;
				case 7:
					// Print info about customers in checkout lines.
					// ShoppingCenter.PrintCustomersInCheckout();
					break;
				case 8:
					// Print info about items at or below re-stocking level.
					// ShoppingCenter.PrintInventory();
					break;
				case 9:
					// Reorder an item.
					// Item.Reorder();
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
