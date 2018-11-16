import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TowersOfHanoi {
	static int solvecount = 0;
	static int diskmovecount = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean exit = false;
		while (!exit) {
			System.out.println("Please enter the number of disks");
			int d = Integer.parseInt(br.readLine());
			System.out.println("The ideal number of moves is " + (d*d-1));
			System.out.println("Please enter the initial position of the disks");
			String i = br.readLine();
			System.out.println("Please enter the destination of top disk to be moved");
			String td = br.readLine();
			System.out.println("Please enter the tempory position of the disk");
			String tp = br.readLine();
			solve(d,i,td,tp);
		}
		br.close();
	}
	public static void solve (int n, String init, String dest, String temp) {
		solvecount++;
		if (n!=0) {
			solve(n-1,init, temp,dest);
			System.out.println("Move disk " + n + " from" + init + " to" + dest);
			solve(n-1,temp,dest,init);
			diskmovecount++;
		}
	}
}