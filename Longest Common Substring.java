// Tabulation
import java.util.* ;
import java.io.*; 
public class Solution {
	public static int lcs(String str1, String str2) {
		// Write your code here.
		// base case
		int l1 = str1.length(), l2 = str2.length();
		int[][] dp = new int[l1+1][l2+1];
		for(int i=0;i<=l1;i++) dp[i][0] = 0;
		for(int i=0;i<=l2;i++) dp[0][i] = 0;

		// compute table
		for(int i=1;i<=l1;i++){
			for(int j=1;j<=l2;j++){
				if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
				else dp[i][j] = 0;
			}
		}

		// find ans
		int max = 0;
		for(int i=0;i<=l1;i++){
			for(int j=0;j<=l2;j++){
				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}
}
