import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeliverySystem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		DEQ<DeliveryPackage> packageQueue = new DEQ<>();
		StackRA<Item> sampleStack = new StackRA<>();
		int numberOfPackages = 0;
		int numberOfItems = 0;

		int std;
		boolean exit = false;
		while (!exit) {
			System.out.println("Please choose from the options below:");
			System.out.println("0	Exit.");
			System.out.println("1 	Pick up an order.");
			System.out.println("2 	Drop off an order.");
			System.out.println("3 	Display number of packages and weight of bag.");
			System.out.println("4	Display number of items and weight of the bag of samples.");
			System.out.println("5	Enjoy an item from the bag of samples.");
			System.out.println("6	Enjoy all the samples in the bag of samples.");
			System.out.println("7	Pick up an express order.");
			try {
				std = Integer.parseInt(br.readLine().trim());
				System.out.println(std);
				switch (std)
				{
				case 0:
					System.out.println("\nGoodbye");
					exit = true;
					break;
				case 1:
					System.out.println("\nPlease enter the name of the items in the package");
					String name = br.readLine().trim();
					System.out.println(name);
					
					System.out.println("\nPlease enter the weight of the items");
					double weight = Double.parseDouble(br.readLine().trim());
					System.out.println(weight);
					
					System.out.println("\nPlease enter the amount of items");
					int amount = Integer.parseInt(br.readLine().trim());
					System.out.println(amount);
					
					System.out.println("\nPlease enter the name of the sender");
					String sender = br.readLine().trim();
					System.out.println(sender);
					
					System.out.println("\nPlease enter the name of the recipient");
					String recipient = br.readLine().trim();
					System.out.println(recipient);
					
					DeliveryPackage dPackage = new DeliveryPackage(name, weight, amount, sender, recipient);
					packageQueue.enqueue(dPackage);
					numberOfPackages++;
					System.out.println("\nPackage of " + name + "s each weighing " + weight + " lbs has been picked up.");
					break;
				case 2:
					DeliveryPackage removedPackage = packageQueue.peek();
					Item removedItem = removedPackage.getItem();
					String removedItemName = removedItem.getName();
					String removedSender = removedPackage.getSender();
					String removedRecipient = removedPackage.getRecipient();
					
					packageQueue.dequeue();
					numberOfPackages--;
					
					System.out.println("\nPackage of " + removedItemName + "s from " + removedSender + " to " + removedRecipient + " has been dropped off");
					System.out.println("\nWould the recipient like you to keep a sample? Yes or No?");
					String answer = br.readLine().trim();
					System.out.println(answer);
					
					if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
						sampleStack.push(removedItem);
						numberOfItems++;
						System.out.println("\nA " + removedItemName + " has been added to your bag of samples");
					}
					else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
						System.out.println("\nNo sample was taken");
					}
					else {
						System.out.println("\nInvalid entry. No sample was taken");
					}
					break;
				case 3:
					DEQ<DeliveryPackage> tempPackageQueue = new DEQ<>();
					double packageBagWeight = 0;
					
					while(!packageQueue.isEmpty()) {
						DeliveryPackage pack = packageQueue.dequeue();
						tempPackageQueue.enqueue(pack);
						packageBagWeight = packageBagWeight + (pack.getItem().getWeight() * pack.getAmount());
					}
					
					packageQueue = tempPackageQueue;
					System.out.println("\nNumber of packages: " + numberOfPackages);
					System.out.println("Weight of bag of packages: " + packageBagWeight);
					break;
				case 4:
					StackRA<Item> tempSampleStack = new StackRA<>();
					double sampleBagWeight = 0;
					
					for (int i = 0; i < numberOfItems; i++) {
						Item item = sampleStack.pop();
						tempSampleStack.push(item);
						sampleBagWeight = sampleBagWeight + item.getWeight();
					}
					
					for (int i = 0; i < numberOfItems; i++) {
						sampleStack.push(tempSampleStack.pop());
					}
					
					System.out.println("\nNumber of Items: " + numberOfItems);
					System.out.println("Weight of bag of samples: " + sampleBagWeight);
					break;
				case 5:
					String sampleItemName = sampleStack.peek().getName();
					sampleStack.pop();
					numberOfItems--;
					System.out.println("\nYou have enjoyed a " + sampleItemName + " from your bag of samples");
					break;
				case 6:
					sampleStack.popAll();
					numberOfItems = 0;
					System.out.println("\nYou have enjoyed all the items in your bag of samples");
					break;
				case 7:
					System.out.println("\nPlease enter the name of the items in the package");
					String expressName = br.readLine().trim();
					System.out.println(expressName);
					
					System.out.println("\nPlease enter the weight of the items");
					double expressWeight = Double.parseDouble(br.readLine().trim());
					System.out.println(expressWeight);
					
					System.out.println("\nPlease enter the amount of items");
					int expressAmount = Integer.parseInt(br.readLine().trim());
					System.out.println(expressAmount);
					
					System.out.println("\nPlease enter the name of the sender");
					String expressSender = br.readLine().trim();
					System.out.println(expressSender);
					
					System.out.println("\nPlease enter the name of the recipient");
					String expressRecipient = br.readLine().trim();
					System.out.println(expressRecipient);
					
					DeliveryPackage expressPackage = new DeliveryPackage(expressName, expressWeight, expressAmount, expressSender, expressRecipient);
					packageQueue.enqueue(expressPackage);
					numberOfPackages++;
					System.out.println("\nExpress package of " + expressName + "s each weighing " + expressWeight + " lbs has been picked up.");
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
				System.out.println("\nThe operation could not be performed");
			}
			catch (ExtendedQueueException eqe) {
				System.out.println("\nThe operation could not be performed");
			}

		}
		br.close();	
	}
}
