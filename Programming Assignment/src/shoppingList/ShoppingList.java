package shoppingList;

import java.util.ArrayList;
import java.util.Iterator;
public class ShoppingList 
{
	ArrayList<Item> items;
	public ShoppingList() 
	{
		items = new ArrayList<Item>();
	}
	public Item getItem(int index) 
	{
		return items.get(index);
	}
	public Item getItem(String name) 
	{
		for(Item item: items) 
		{
			if(item.getName().equalsIgnoreCase(name))
				return item;
		}
		return null;
	}
	public ArrayList<Item> getItems() 
	{
		return items;
	}
	public boolean addItem(String name, String brand, double amount, double estPrice) 
	{
		if(getItem(name) == null) 
		{
			items.add(new Item(name, brand, amount, estPrice));
			return true;
		}
		else 
		{
			return false;
		}
	}
	public void searchList(String name)
	{
		Item item = getItem(name);	
		if(item == null)
			System.out.println("Error. Item not found");
		else 
		{
			System.out.println(item);
		}
	}
	public void printList()
	{
		Iterator<Item>it=items.iterator();
		while(it.hasNext()) 
		{
			System.out.println(it.next());
		}
	}
	public void removeFromList(Item i)
	{
		Iterator<Item>it = items.iterator();
		while(it.hasNext())
		{
			if (it.next().equals(i))
				it.remove();
		}
		System.out.println("Item not found in List");
	}
	public boolean removeItem(String name)
	{
		Item item = getItem(name);
		return items.remove(item);
	}
	public double totalCost()
	{
		double total = 0;
		for(Item item: items)
		{ 
			double amount = item.getAmount();
			double price = item.getEstPrice();
			double cost = amount*price;
			total += cost;
		}
		return total;
	}
}
