import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompareToDriver {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		boolean end = false;
		while(!end)
		{
			System.out.println("Please enter the first string to be compared");
			String firstString =br.readLine();
			System.out.println("Please enter the second string to be compared");
			String secondString =br.readLine();
			System.out.println(firstString.compareTo(secondString));
			System.out.println("Is there another set of strings to compare? yes or no?");
			String response =br.readLine();
			if (response.equalsIgnoreCase("yes"))
			{ }
			else if (response.equalsIgnoreCase("no"))
			{
				end=true;
				System.out.println("GoodBye");
			}
			else
			{
				System.out.println("Invalid entry please try again");
			}
		}
	}
}