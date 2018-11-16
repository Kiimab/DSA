import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pascal {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter the number of rows to print: ");
		int rows = Integer.parseInt(br.readLine());
		System.out.println("Pascal Triangle:");
		print(rows);
		br.close();
	}

	public static void print(int n) {
		String[][] triangle = new String[n][2*n];
		//		for (int i = 0; i < n; i++) {
		//			for (int k = 0; k < n - i; k++) {
		//				triangle [i][k] = " "; // print space for triangle like structure
		//			}
		//			for (int j = 0; j <= i; j += 2) {
		//				triangle[i][j] = String.valueOf(pascal(i,j));
		//				triangle[i][j+1] = " ";
		//			}
		//		}
		//		
		for (int i = 0; i < n; i++) {
			int skip = 0;
			for (int j = 0; j < (2 * n); j++) {
				if (j >= (n-i) && j <= (n + i)) {
					triangle[i][j] = String.valueOf(pascal(i, (j-n) + i - skip));
					if ((j + 1) < (2 * n)) {
						triangle[i][j+1] = " ";
					}
					j++;
					skip ++;
				}
				else {
					triangle[i][j] = " ";
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2*n; j++) {
				System.out.printf(triangle[i][j]);
			}
			System.out.println();
		}

		//		for (int i = 0; i < n; i++) {
		//			for (int k = 0; k < n - i; k++) {
		//				System.out.print(" "); // print space for triangle like structure
		//			}
		//			for (int j = 0; j <= i; j++) {
		//				System.out.print(pascal(i, j) + " ");
		//			}
		//			System.out.println();
		//		}
	}

	public static int pascal(int n, int k) {
		if (k == 0 || k == n) {
			return 1;
		} else {
			return pascal(n - 1, k) + pascal(n - 1, k - 1);
		}
	}
}