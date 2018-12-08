
public class Item {
	private String name;
	private int amount;
	
	public Item(String name, int amount) {
		this.name = name;
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void increaseAmount(int number) {
		amount += number;
	}
	
	public void decreaseAmount(int number) {
		amount -= number;
	}
	
	public void setAmount(int number) {
		amount = number;
	}
	
	public String toString() {
		return name;
	}
}
