package shoppingList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Driver 
{
	static int std;
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		ShoppingList list = new ShoppingList();
		
		boolean exit = false;
		System.out.println("Welcome to the Shopping List Application.");
		
		while (!exit) {
			System.out.println("\nPlease choose from the options below:");
			System.out.println("0 	Exit");
			System.out.println("1 	Add an item to the Shopping List");
			System.out.println("2 	Print content of Shopping List and total estimated cost");
			System.out.println("3	Search for items in Shopping List");
			System.out.println("4	Delete and item from the Shopping List");
			try {
				std = Integer.parseInt(br.readLine());
				switch (std)
				{
				case 0:
					System.out.println("GoodBye");
					exit=true;
					break;
				case 1: 
					double amount;
					double price;
					System.out.println("\nPlease enter the name");
					String name = br.readLine();
					System.out.println("Please enter the brand");
					String brand = br.readLine();
					System.out.println("Please enter the amount");
					amount = Double.parseDouble(br.readLine());
					System.out.println("Please enter  the estimated price of the item");
					price = Double.parseDouble(br.readLine());
					list.addItem(name, brand, amount, price);
					break;
				case 2:
					if (list.getItems().isEmpty()) {
						System.out.println("\nThe shopping list is empty");
					}
					else {
						System.out.println("\nThe Items in the list are:");
						list.printList();
						System.out.println("\nThe total cost is: " + list.totalCost());
					}
					break;
				case 3:
					String itemName= "";
					System.out.println("\nPlease enter the name of the item you would like to search for\n");
					itemName = br.readLine();
					list.searchList(itemName);
					break;
				case 4:
					String itemNamee= br.readLine();
					if(list.removeItem(itemNamee) == true)
					{
						System.out.println("\nThe item was successfully removed");
						break;
					}
					else {
						System.out.println("\nItem not found");
					}
				default:
					System.out.println("\nInvalid Option\n");
				}
			}
			catch (NumberFormatException e) {
				System.out.println("\nInvalid Input. Please Try Again");
			}
			
		}
		br.close();
	}
}