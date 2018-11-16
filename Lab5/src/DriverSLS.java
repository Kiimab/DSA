import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DriverSLS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StackSLS<Object> stack = new StackSLS<>();

		int std;
		boolean exit = false;
		while (!exit) {
			System.out.println("Please choose from the options below:");
			System.out.println("1 	Push item onto stack.");
			System.out.println("2 	Pop item from stack");
			System.out.println("3 	Display top item from stack");
			System.out.println("4	Display items in stack");
			System.out.println("5	Clear stack");
			System.out.println("6	Exit");
			try {
				std = Integer.parseInt(br.readLine());
				System.out.println(std);
				switch (std)
				{
				case 1:
					System.out.println("\nPlease enter the item");
					Object item = br.readLine();
					stack.push(item);
					System.out.println(item + " has been pushed onto stack.");
					break;
				case 2:
					System.out.println(stack.pop() + " has been removed from the stack.");
					break;
				case 3:
					System.out.println(stack.peek());
					break;
				case 4:
					if (stack.isEmpty()) {
						System.out.println("The stack is empty");
					}
					else {
						System.out.println(stack);
					}
					break;
				case 5:
					stack.popAll();
					System.out.println("Stack has been cleared");
					break;
				case 6:
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
			catch (StackException se) {
				System.out.println("\nThe operation could not be performed");
			}

		}
		br.close();	
	}
}
