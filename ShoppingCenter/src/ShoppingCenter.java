import java.util.ArrayList;
public class ShoppingCenter {
	
	private ArrayList <Customer> shoppers;
	private ArrayList <Item> inventory;
	private DEQ<Customer> express;
	private DEQ<Customer> regular1;
	private DEQ<Customer> regular2;
	public static void addCustomer(String name, int numItems) {
		
	}
	
	public static void printCustomer(Customer customer) {
		for(int i = 0; i < shoppers.size(); i++) {
			if(shoppers.get(i) == customer.get(i)) {
				shoppers.toString();
			}
		}
	}
	public static void printCustomer(String name) {
		for(int i = 0; i < shoppers.size(); i++) {
			if(shoppers.get(i).getName() == name) {
				shoppers.toString();
			}
		}
	}
	public static void printAllCustomerStillShopping() {
		for(Customer cus: shoppers) {
			shoppers.toString();
		}
	}
	public void reorderSpecificItem(Customer customer, Item item) {
		for(Item i: inventory) {
			if(i.getQuantity() > 0) {
				customer.takeItem();
			}
		}
	}
	
	public void checkout() {
		int expT = express.peek().getTime();
		int reg1 = regular1.peek().getTime();
		int reg2 = regular2.peek().getTime();
		if(expT>reg1) {
			if(expT>reg2) {
				System.out.println("Does" + express.peek().getName() + "wish to leave or return shopping?"));
			}
		}
	}
}