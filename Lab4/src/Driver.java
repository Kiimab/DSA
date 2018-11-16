import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		CDLS<Object> list = new CDLS<>();
		int std = 0;
		boolean end = false;
		while(!end)
		{
			System.out.println("Welcome. Select from the following Menu");
			System.out.println("0 	Exit Program");
			System.out.println("1 	Insert item to the list");
			System.out.println("2 	Remove item from list");
			System.out.println("3 	Get item from list");
			System.out.println("4	Clear list");
			System.out.println("5	Display size and contents of list");
			System.out.println("6	Reverse the list");
			try {
				std = Integer.parseInt(br.readLine().trim());
				System.out.println(std);
				int index = 0;
				switch (std)
				{
				case 0:
					System.out.println("GoodBye");
					br.close();
					end = true;
					break;
				case 1: 
					System.out.println("Please enter the item");
					String item = br.readLine().trim();
					System.out.println(item);
					System.out.println("Please enter the index");
					index = Integer.parseInt(br.readLine().trim());
					System.out.println(index);
					list.add(index,item);
					System.out.println("You successfully added " + item + " to the list at index " + index);
					break;
				case 2: 
					System.out.println("Please enter the position you would like to remove an item from");
					index = Integer.parseInt(br.readLine().trim());
					System.out.println(index);
					Object temp = list.get(index);
					list.remove(index);
					System.out.println("The item at index " + index + " that was removed is " + temp);
					break;
				case 3:
					System.out.println("What is the index of the item you would like to retrieve");
					index = Integer.parseInt(br.readLine().trim());
					System.out.println(index);
					System.out.println("The item " + list.get(index) + " was retrieved from position " + index);
					break;
				case 4:
					list.removeAll();
					System.out.println("The list has been cleared");
					break;
				case 5:
					if (list.isEmpty()) {
						System.out.println("The list is empty");
					}
					else {
						System.out.println("The Items in the list are:");
						System.out.println(list);
						System.out.println("The total number of items in the list is: " + list.size());
					}
					break;
				case 6:
					if (list.isEmpty())
					{
						System.out.println("The list is empty");
					}
					else
					{
						CDLS<Object> temp1 = new CDLS<>();
						for(int i=list.size()-1; i>=0; i--)
						{
							temp1.add(list.size() - i - 1, list.get(i));
						}
						list=temp1;
						System.out.println("The list has been reversed");
					}
					break;
				default:
					System.out.println("Invalid entry. Please try again");
					break;
				}
			}
			catch (NumberFormatException nfe) {
				System.out.println("Invalid input. Please try again");
			}
			catch (ListIndexOutOfBoundsException lie) {
				System.out.println("Invalid index error. Please try again");
			}
		}
	}
}