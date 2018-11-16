import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Means {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		System.out.print("Please enter the number of pairs: ");
		try {
			int n = Integer.parseInt(br.readLine());
			if (n < 0) {
				throw new NumberFormatException();
			}
			System.out.println(n);
			int number = 0;
			double weight = 0.0;
			double simpleMean = 0.0;
			double weightedMean = 0.0;
			
			ArrayList<Double> numbersTimesWeights = new ArrayList<>();
			ArrayList<Integer> numbers = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				System.out.print("Enter number " + (i+1) + ": ");
				number = Integer.parseInt(br.readLine());
				System.out.println(number);
				System.out.print("Enter weight " + (i+1) + ": ");
				weight = Double.parseDouble(br.readLine());
				System.out.println(weight);
				numbers.add(number);
				numbersTimesWeights.add(number * weight);
			}
			
			for (Integer numb: numbers) {
				simpleMean += numb;
			}
			
			if (numbers.size() > 0) {
				simpleMean = simpleMean / numbers.size();
			}
			
			for (Double numbTimesWeight: numbersTimesWeights) {
				weightedMean += numbTimesWeight;
			}
			System.out.println("\nWeighted arithmetic mean of these " + n + " pairs is: " + weightedMean);
			System.out.println("Simple arithmetic mean of these " + n + " pairs is: " + simpleMean);
			br.close();
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid Input");
			br.close();
		}
	}
}
