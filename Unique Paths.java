import java.io.*;
import java.util.*;

public class C {
	public void main() {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}

		Scanner scan = new Scanner(System.in);

		//input
		int m = scan.nextInt();
		int n = scan.nextInt();

		uniquePaths(m, n);

		// int[][] memo = new int[m][n];
		// for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) memo[i][j] = -1;

		//function
		//System.out.println(uniquePaths(m - 1, n - 1, 0, 0, memo));


	}

	//Using DP
	// public int uniquePaths(int m, int n, int i, int j, int[][] memo) {
	// 	if (i == m && j == n) return 1;
	// 	if (i > m || j > n) return 0;
	// 	if (memo[i][j] != -1) return memo[i][j];
	// 	else {
	// 		return memo[i][j] = uniquePaths(m, n, i + 1, j, memo) + uniquePaths(m, n, i, j + 1, memo);
	// 	}
	// }

	//Using Combination
	public void uniquePaths(int m, int n) {
		int total = m + n - 2;
		int r = m - 1;
		double res = 1;

		for (int i = 1; i <= r; i++) {
			res = res * (total - r + i) / i;
		}

		System.out.println((int) res);
	}
}
