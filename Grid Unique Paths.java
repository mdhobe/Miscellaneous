//Memoization
import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		// Write your code here.
		int[][] dp = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				dp[i][j] = -1;
			}
		}
		return count(m-1, n-1, dp);
	}

	public static int count(int row, int col, int[][] dp){
		if(row == 0 && col == 0) return 1;
		if(row < 0 || col < 0) return 0;
		if(dp[row][col] != -1) return dp[row][col];

		int left = count(row,col-1, dp);
		int up = count(row-1, col, dp);

		return dp[row][col] = left + up;
	}
}

//Tabulation
import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		// Write your code here.

		int[][] dp = new int[m][n];
		dp[0][0] = 1;

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i == 0 && j == 0) dp[i][j] = 1;
				else {
					int left = 0, up = 0;
					if(j > 0) left = dp[i][j-1];
					if(i > 0) up = dp[i-1][j];
					dp[i][j] = left + up;
				}
			}
		}

		return dp[m-1][n-1];
	}
}

//Space Optimization
import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		// Write your code here.

		int[] dp = new int[n];

		for(int i=0;i<m;i++){
			int[] temp = new int[n];
			for(int j=0;j<n;j++){
				if(i == 0 && j == 0) temp[j] = 1;
				else {
					int left = 0, up = 0;
					if(j > 0) left = temp[j-1];
					if(i > 0) up = dp[j];
					temp[j] = left + up;
				}
			}
			for(int j=0;j<n;j++) dp[j] = temp[j];
		}

		return dp[n-1];
	}
}
