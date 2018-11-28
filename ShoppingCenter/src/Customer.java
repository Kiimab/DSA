
public class Customer {
	private String name;
	private int numItems;
	private int time;
	
	public Customer(String name, int numItems) {
		this.name = name;
		this.numItems = numItems;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumItems() {
		return numItems;
	}
	
	public void addItems(int number) {
		numItems += number;
	}
	
	public void removeItems(int number) {
		numItems -= number;
	}
	
	public int getTime() {
		return time;
	}
	
	public void incrementTime() {
		time++;
	}
}
