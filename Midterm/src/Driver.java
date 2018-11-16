import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		Queue<CustomerBuyQueue> CustomerBuy = new Queue<>();
		ListArrayListBased<FruitItem> fruitlist = new ListArrayListBased<>();
		StackRA<CustomerBuyQueue> pendingCust = new StackRA<>();
		int std;
		int amount;
		int cusleft = 0;
		int custpen = 0;
		int index = 0;
		int numWaiting = 0;
		boolean exit = false;
		System.out.println("Welcome to the Fruit Centre! \n "
				+ "enter number of apples in stock:");
		FruitItem apples = new FruitItem("apples", amount = Integer.parseInt(br.readLine().trim()));
		System.out.println("enter number of pears in stock:");
		FruitItem pears = new FruitItem("pears", amount = Integer.parseInt(br.readLine().trim()));
		System.out.println("enter number of peaches in stock:");
		FruitItem peaches = new FruitItem("peaches", amount = Integer.parseInt(br.readLine().trim()));
		fruitlist.add(index, apples);
		index++;
		fruitlist.add(index, pears);
		index++;
		fruitlist.add(index, peaches);
		System.out.println("Please select from the following menu");
		System.out.println("1 \tCustomer enters with request to buy");
		System.out.println("2 \tCustomer enters with fruit to sell");
		System.out.println("3 \tCustomer with request to buy is served");
		System.out.println("4 \tDisplay customers waiting to be served and their request");
		System.out.println("5 \tDisplay pending request waiting to be processed.");
		System.out.println("6 \tProcess pending requests");
		System.out.println("7 \tDisplay number of customers that have left");
		System.out.println("8 \tExit");
		while (!exit) {
			try {
				std = Integer.parseInt(br.readLine().trim());
				System.out.println(std);
				switch (std)
				{
				case 1:
					int num= 0;
					System.out.println("Welcome! Your name please:");
					String name = br.readLine().trim();
					System.out.println("How many Apples do you want:");
					FruitItem customerApples = new FruitItem(" apples", num = Integer.parseInt(br.readLine().trim()));
					System.out.println("How many Pears do you want:");
					FruitItem customerPears = new FruitItem(" pears", num= Integer.parseInt(br.readLine().trim()));
					System.out.println("How many Peaches do you want");
					FruitItem customerPeaches = new FruitItem(" peaches", num = Integer.parseInt(br.readLine().trim()));
					CustomerBuyQueue BCustomer = new CustomerBuyQueue (name, customerApples, customerPears, customerPeaches );
					CustomerBuy.enqueue(BCustomer);
					numWaiting++;
					System.out.println(name + " requesting " + customerApples.getAmount()+ customerApples.getName() + " , " +
							customerPears.getAmount() + customerPears.getName() +  " and " + customerPeaches.getAmount() + customerPeaches.getName() + " is now waiting");
					break;
				case 2:
					System.out.println("Welcome! Your name please:");
					String sellName = br.readLine().trim();
					System.out.println("How many Apples do you have:");
					FruitItem sellApples = new FruitItem(" apples", num = Integer.parseInt(br.readLine().trim()));
					apples.setAmount(num);
					System.out.println("How many Pears do you have:");
					FruitItem sellPears = new FruitItem(" pears", num= Integer.parseInt(br.readLine().trim()));
					pears.setAmount(num);
					System.out.println("How many Peaches do you have:");
					FruitItem sellPeaches = new FruitItem(" peaches", num = Integer.parseInt(br.readLine().trim()));
					peaches.setAmount(num);
					CustomerSeller  sCustomer = new CustomerSeller(sellName, sellApples, sellPears, sellPeaches);
					System.out.println("Thanks" + sellName + " here is your receipt for the " + sellApples.getAmount() + sellApples.getName() + " , " +
							sellPears.getAmount() + sellPears.getName() +  " and " + sellPeaches.getAmount() + sellPeaches.getName() + "!");
					cusleft++;
					break;
				case 3:
					CustomerBuyQueue temp = CustomerBuy.dequeue();
					if (temp ==null){
					}
					else if(temp.getApples().getAmount() >=apples.getAmount() && temp.getPears().getAmount() >=pears.getAmount() && temp.getPeaches().getAmount() >=peaches.getAmount()){
						System.out.println(temp.getName() + " is leaving with" + temp.getApples().getAmount()+ temp.getName() + " , " +
								temp.getPears().getAmount() + temp.getPears().getName() +  " and " + temp.getPeaches().getAmount() + temp.getPeaches().getName());
						apples.amount = apples.amount - temp.getApples().getAmount();
						pears.amount =pears.amount - temp.getPeaches().getAmount();
						peaches.amount = peaches.amount - temp.getPeaches().getAmount();
						CustomerBuy.dequeue();
					}
					else{
						pendingCust.push(CustomerBuy.dequeue());
						cusleft++;
						custpen++;
					}
					break;
				case 4:
					System.out.println("The following customers are waiting to be served:");
					for(int i = 0; i > numWaiting; i++){
						System.out.println(CustomerBuy.peek().getName() + " requesting " +
								CustomerBuy.peek().getApples().getAmount() + CustomerBuy.peek().getApples().getName() +  CustomerBuy.peek().getPears().getAmount() +
								CustomerBuy.peek().getPears().getName() + CustomerBuy.peek().getPeaches().getAmount() + CustomerBuy.peek().getPeaches().getName());
					}
					break;
				case 5:
					System.out.println("The following requests are pending:");
					for(int i = 0; i >= custpen; i++){
						System.out.println(pendingCust.peek().getApples().getAmount() + pendingCust.peek().getApples().getName() +  pendingCust.peek().getPears().getAmount() +
								pendingCust.peek().getPears().getName() + pendingCust.peek().getPeaches().getAmount() + pendingCust.peek().getPeaches().getName());
						break;
					}
					break;
				case 6:
					for(int i = 0; i >= custpen; i++){
						while(pendingCust.peek().getApples().getAmount() >=apples.getAmount() && pendingCust.peek().getPears().getAmount() >=pears.getAmount() && pendingCust.peek().getPeaches().getAmount() >=peaches.getAmount()){
							System.out.println(pendingCust.peek().getName()  + " requesting" + pendingCust.peek().getApples().getAmount() + pendingCust.peek().getApples().getName() +  pendingCust.peek().getPears().getAmount() +
									pendingCust.peek().getPears().getName() + pendingCust.peek().getPeaches().getAmount() + pendingCust.peek().getPeaches().getName());
							pendingCust.pop();
						}
					}
					break;
				case 7:
					System.out.println(cusleft + "customers have left.");
					break;
				case 8:
					System.out.println("The Fruit Centre is Closing:Goodbye...");
					exit = true;
					break;
				default:
					System.out.println("\nInvalid option please try again");
					break;
				}
			}
			catch (NumberFormatException e) {
				System.out.println("\nInvalid Input. Please Try Again");
			}
			catch (StackException se) {
				System.out.println("\nThe operation could not be performed");
			}
			catch (QueueException qe) {
				System.out.println("\nNo customer is waiting to be served");
			}
			catch (ExtendedQueueException eqe) {
				System.out.println("\nThe operation could not be performed");
			}
			catch (ListException le) {
				System.out.println("\nThe operation could not be performed");
			}
			catch (ListIndexOutOfBoundsException lie) {
				System.out.println("You cannot add an item at that index");
			}
			if (!exit)
			{
				System.out.println("You know the options. Make your menu selection now:");
			}

		}
		br.close();
	}
}