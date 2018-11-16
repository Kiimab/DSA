import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DEQDriver {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		DEQ<Object> queue = new DEQ<>();
		int std;
		boolean exit = false;
		while (!exit) {
			System.out.println("Please choose from the options below:");
			System.out.println("1 	Insert item at back of queue");
			System.out.println("2 	Insert item at front of queue");
			System.out.println("3 	Remove item from front of queue");
			System.out.println("4 	Remove item from back of queue");
			System.out.println("5 	Display front item of queue");
			System.out.println("6 	Display last item of queue");
			System.out.println("7	Clear queue");
			System.out.println("8	Display content of queue");
			System.out.println("9	Exit");
			try {
				std = Integer.parseInt(br.readLine());
				System.out.println(std);
				switch (std) {
				case 1:
					System.out.println("\nPlease enter the item");
					Object item = br.readLine();
					System.out.println(item);
					queue.enqueue(item);
					break;
				case 2:
					System.out.println("\nPlease enter the item");
					Object itemf = br.readLine();
					System.out.println(itemf);
					queue.enqueueFirst(itemf);
					break;
				case 3:
					System.out.println(queue.dequeue());
					break;
				case 4:
					System.out.println(queue.dequeueLast());
					break;
				case 5:
					System.out.println(queue.peek());
					break;
				case 6:
					System.out.println(queue.peekLast());
					break;
				case 7:
					queue.dequeueAll();
					System.out.println("\nThe queue has been Cleared");
					break;
				case 8:
					System.out.println(queue);
					break;
				case 9:
					System.out.println("\nGoodbye");
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
			catch (QueueException qe) {
				System.out.println("\nThe operation could not be performed. The Queue may be empty.");
			}
			catch (ExtendedQueueException eqe) {
				System.out.println("\nThe operation could not be performed. The Queue may be empty");
			}
		}
		br.close();	
	}
}