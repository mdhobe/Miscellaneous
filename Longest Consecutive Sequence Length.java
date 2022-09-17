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
		String text1 = "abcde", text2 = "ace";
		System.out.println(longestCommonSubsequence(text1, text2));
	}

	int[][] dp;
	public int longestCommonSubsequence(String text1, String text2) {
		int n = text1.length(), m = text2.length();
		dp = new int[n][m];
		for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) dp[i][j] = -1;
		return comparision(n - 1, m - 1, text1, text2);
	}

	public int comparision(int index1, int index2, String text1, String text2) {
		if (index1 < 0 || index2 < 0) return 0;

		if (dp[index1][index2] != -1) return dp[index1][index2];

		if (text1.charAt(index1) ==  text2.charAt(index2)) return dp[index1][index2] = 1 + comparision(index1 - 1, index2 - 1, text1, text2);
		else return dp[index1][index2] = Math.max(comparision(index1 - 1, index2, text1, text2), comparision(index1, index2 - 1, text1, text2));
	}
}
