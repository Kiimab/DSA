import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyHelloClass 
{
	static int stdin;
	static String result = "";
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		System.out.println("Please enter the number of people");
		
		try {
			String numberOfPeople = br.readLine();
			System.out.println(numberOfPeople);
			stdin = Integer.parseInt(numberOfPeople);
			String name;
			switch(stdin) {
				case 1:
					System.out.println("Enter name number 1");
					name = br.readLine();
					System.out.println(name);
					result = result + name + " says ";
					break;
				case 2:
					System.out.println("Enter name number 1");
					name = br.readLine();
					System.out.println(name);
					result = name + " and ";
					
					System.out.println("Enter name number 2");
					name = br.readLine();
					System.out.println(name);
					result = result + name + " say ";
					break;
				default:
					for(int i=0; i<stdin; i++) {
						if (i < stdin-1){
							System.out.println("Enter name number " + i);
							name = br.readLine();
							System.out.println(name);
							result = result + name + ", ";
						}
						else if (i== stdin-1) {
							System.out.println("Enter name number " + i);
							name = br.readLine();
							System.out.println(name);
							result = result + "and " + name + " say ";
						}
					}
			}
			result = result + "Hello Class!!!";
			System.out.println(result);
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid input. Please try again");
		}
		br.close();
	}
}