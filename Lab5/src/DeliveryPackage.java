public class DeliveryPackage {
	Item item;
	int amount;
	String sender;
	String recipient;
	
	public DeliveryPackage(String itemName, double itemWeight, int amount, String sender, String recipient) {
		item = new Item(itemName, itemWeight);
		this.amount = amount;
		this.sender = sender;
		this.recipient = recipient;
	}
	
	public Item getItem() {
		return item;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String getSender() {
		return sender;
	}
	
	public String getRecipient() {
		return recipient;
	}
}
