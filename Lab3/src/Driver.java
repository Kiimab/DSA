import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		MyListReferenceBased<Object> list = new MyListReferenceBased<>();
		int std = 0;
		boolean end = false;
		while(!end)
		{
			System.out.println("Welcome. Select from the following Menu");
			System.out.println("1 	Insert item to the list");
			System.out.println("2 	Remove item from list");
			System.out.println("3 	Get item from list");
			System.out.println("4	Clear list");
			System.out.println("5	Display size and contents of list");
			System.out.println("6	Delete largest item in the list");
			System.out.println("7	Reverse the list");
			System.out.println("8	Exit Program");
			try {
				std = Integer.parseInt(br.readLine().trim());
				System.out.println(std);
				int index = 0;
				String response = "";
				switch (std)
				{
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
					System.out.println("Are you sure you would like to remove all the items from the list? yes or no");
					response = br.readLine().trim();
					System.out.println(response);
					if(response.equalsIgnoreCase("yes"))
					{
						list.removeAll();
						System.out.println("The list has been cleared");
					}
					else if(response.equalsIgnoreCase("no"))
					{ }
					else
					{
						System.out.println("Invalid entry.Please try again");
					}
					break;
				case 5:
					if (list.isEmpty()) {
						System.out.println("The list is empty");
					}
					else {
						System.out.println("The Items in the list are: ");
						for(int i= 0; i < list.size(); i++)
						{
							System.out.println(list.get(i));
						}
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
						int indexOfLargest = 0;
						for(int i = 0; i<list.size(); i++)
						{
							if(list.get(i).toString().compareTo(list.get(indexOfLargest).toString())>0)
							{
								indexOfLargest = i;
							}
						}
						list.remove(indexOfLargest);
					}
					break;
				case 7:
					MyListReferenceBased<Object> temp1 = new MyListReferenceBased<>();
					System.out.println("Are you sure you would like to reverse the list? yes or no");
					response = br.readLine().trim();
					System.out.println(response);
					if (response.equalsIgnoreCase("yes"))
					{
						for(int i=list.size()-1; i>=0; i--)
						{
							temp1.add(list.size() - i - 1, list.get(i));
						}
						list=temp1;
						System.out.println("The list has been reversed");
					}
					else if (response.equalsIgnoreCase("no"))
					{ }
					else 
					{
						System.out.println("Invalid entry. Please try again");
					}
					break;
				case 8:
					System.out.println("GoodBye");
					br.close();
					end = true;
					break;
				default:
					System.out.println("Invalid entry. Please try again");
					break;
				}
			}
			catch (NumberFormatException nfe) {
				System.out.println("Invalid input. Please try again");
			}
			catch (ListException le) {
				System.out.println("The list is full. Item could not be added");
			}
			catch (ListIndexOutOfBoundsException lie) {
				System.out.println("Invalid index error. Please try again");
			}
		}
	}
}
