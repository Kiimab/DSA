import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver{

	public static void main (String[] args) throws IOException{
		Sorter sorter = new Sorter();
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.println("Please enter the number of integers to be sorted");
		
		int n = Integer.parseInt(br.readLine());
		int intArray[]= new int[n];
		for (int i=0; i<n; i++) {
			System.out.println("Enter integer number " + (i+1) + ":");
			intArray[i]= Integer.parseInt(br.readLine());
		}
		
		System.out.println("\tBubble Sort");
		System.out.println("Input Data: ");
		for(int t=0; t < intArray.length; t++) {
			System.out.print(intArray[t] + "\t");
		}
		System.out.println("\nSorted Data: ");
		int bubArray[] = sorter.bubbleSort(intArray);
		for(int t=0; t< bubArray.length; t++) {
			System.out.print(bubArray[t] + "\t");
		}
		System.out.println("\nNumber of comparisons: " + sorter.getComparisons());
		System.out.println("Number of swaps: " + sorter.getSwaps());
		
		System.out.println("\n\tImproved Bubble Sort");
		System.out.println("\n\tSelection Sort");	
		System.out.println("\n\tImproved Selection Sort");
		System.out.println("\n\tInsertion Sort");
	}
}