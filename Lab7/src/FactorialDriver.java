import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class FactorialDriver {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 1;
		long fact = 0;
		System.out.println(" Please enter the number");
		n = Integer.parseInt(br.readLine());
		
		System.out.println("\nSolution 1:");
		for (int i = n; i > 0; i--) {
			System.out.print(i + "! = ");
			System.out.println(rfactMethod(i));
		}
		
		System.out.println("\nSolution 2:");
		for (long i = n; i > 0; i--) {
			System.out.print(i + "! = ");
			System.out.println(rfactMethod2(i));
		}
		
		System.out.println("\nSolution 3:");
		for (BigInteger i = BigInteger.valueOf(n); i.compareTo(BigInteger.valueOf(0)) > 0; i = i.subtract(BigInteger.valueOf(1))) {
			System.out.print(i + "! = ");
			System.out.println(rfactMethod3(i));
		}
	}

	public static int rfactMethod (int n){
		int result = 0;
		if ((n== 1) || (n==0)){
			result =1; 
		}
		else{
			result = (n * rfactMethod(n-1));
		}
		return result;
	}

	public static long rfactMethod2 (long n){
		long result = 0;
		if ((n== 1) || (n==0)){
			result =1; 
		}
		else{
			result = (n * rfactMethod2(n-1));
		}
		return result;
	}
	
	public static BigInteger rfactMethod3 (BigInteger n){
		BigInteger result = BigInteger.valueOf(0);
		if ((n.equals(BigInteger.valueOf(1))) || (n.equals(BigInteger.valueOf(0)))){
			result = BigInteger.valueOf(1); 
		}
		else{
			result = n.multiply(rfactMethod3(n.subtract(BigInteger.valueOf(1))));
		}
		return result;
	}
}