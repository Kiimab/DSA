import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver{

	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.println("Please enter the number of integers to be sorted");
		int n = Integer.parseInt(br.readLine());
		int intArray[]= new int[n];
		for (int i=0; i<n;i++) {
			System.out.println("Enter integer number " + (i+1) + " : ");
			intArray[i]= Integer.parseInt(br.readLine());
		}
		System.out.println("Select from the following menu");
		System.out.println("1 \t Bubble Sort");
		
		int bubArray[] = BubbleSort(intArray, n);
		System.out.println("Input Data: ");
		for(int t=0; t < intArray.length; t++) {
			System.out.print(intArray[t] + "\t");
		}
		System.out.println("\nSorted Data: ");
		for(int t=0; t< bubArray.length; t++) {
			System.out.print(bubArray[t] + "\t");
		}
		
		System.out.println("2 \t Improved Bubble Sort");
		System.out.println("3 \t Selection Sort");	
		System.out.println("4 \t Improved Selection Sort");
		System.out.println("5 \t Insertion Sort");
	}


	public static int[] BubbleSort(int iArray[], int numItems) {

		for(int i = 0; i < numItems-1; i++) {
			int compar = 1;
			compar++;
			int t =Integer.parseInt(String.valueOf(iArray[i]));
			int g = Integer.parseInt(String.valueOf(iArray[i+1]));

			if(t > g) {
				Object temp = iArray[i];
				iArray[i] = iArray[i+1];
			}
		}
		return iArray;
	}
}