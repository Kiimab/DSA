import java.util.ArrayList;
import java.util.Iterator;
public class ShoppingCenter {
	private ArrayList<Customer> shoppers;
	private ArrayList<Item> inventory;
	private ArrayList<Item> itemsToRestock;
	
	public ShoppingCenter() {
		shoppers = new ArrayList<>();
		inventory = new ArrayList<>();
		itemsToRestock = new ArrayList<>();
	}
	
	public void addCustomer(String name, int numItems) throws NonUniqueException {
		for (Customer c : shoppers) {
			if (c.getName().equalsIgnoreCase(name)) {
				throw new NonUniqueException("Customer's name must be unique");
			}
		}
		Customer customer = new Customer(name, numItems);
		shoppers.add(customer);
	}
	
	public void addCustomer(Customer customer) throws NonUniqueException {
		for (Customer c : shoppers) {
			if (c.getName().equalsIgnoreCase(customer.getName())) {
				throw new NonUniqueException("Customer's name must be unique");
			}
		}
		shoppers.add(customer);
	}
	
	public void addItem (String name, int amount) throws NonUniqueException {
		for (Item i : inventory) {
			if (i.getName().equalsIgnoreCase(name)) {
				throw new NonUniqueException("Item's name must be unique");
			}
		}
		Item item = new Item(name, amount);
		inventory.add(item);
	}
	
	public void addItem (Item item) throws NonUniqueException {
		for (Item i : inventory) {
			if (i.getName().equalsIgnoreCase(item.getName())) {
				throw new NonUniqueException("Item's name must be unique");
			}
		}
		inventory.add(item);
	}
	
	public Customer searchCustomer(String name) {
		Iterator<Customer> shopperItty = shoppers.iterator();
		
		while (shopperItty.hasNext()) {
			Customer customer = shopperItty.next();
			if (customer.getName().equalsIgnoreCase(name)) {
				return customer;
			}
		}
		return null;
	}
	
	public Item searchItem(String name) {
		Iterator<Item> inventoryItty = inventory.iterator();
		
		while (inventoryItty.hasNext()) {
			Item item = inventoryItty.next();
			if (item.getName().equalsIgnoreCase(name)) {
				return item;
			}
		}
		return null;
	}
	
	public void addToRestockList(Item item) {
		Iterator<Item> restockListItty = itemsToRestock.iterator();
		
		boolean found = false;
		while (restockListItty.hasNext()) {
			Item i = restockListItty.next();
			if (i.getName().equalsIgnoreCase(item.getName())) {
				i.increaseAmount(1);
				found = true;
			}
		}
		
		if (!found) {
			itemsToRestock.add(item);
		}
	}
	
	public void takeItem(String customerName, String itemName) throws InvalidException{
		Customer customer = searchCustomer(customerName);
		Item item = searchItem(itemName);
		
		if (customer == null) {
			throw new InvalidException("Customer " + customerName + " does not exist.");
		}
		
		if (item == null) {
			throw new InvalidException("Item " + itemName + " does not exist.");
		}
		
		// Remove 1 of the specified item from shelf.
		if (item.getAmount() > 1) {
			item.decreaseAmount(1);
		}
		else {
			inventory.remove(item);
		}
		
		//Increment customer's number of items
		customer.addItems(1);
		
		// add item to list of items that are in need of restocking
		Item removedItem = new Item(itemName, 1);
		addToRestockList(removedItem);
		
		// Pass 1 minute of time
		for (Customer c : shoppers) {
			c.incrementTime();
		}
	}
}
