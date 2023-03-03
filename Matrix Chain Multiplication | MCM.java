// Memoization
public class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
		// Write your code here
		int[][] dp = new int[N][N];
		for(int i=0;i<N;i++) for(int j=0;j<N;j++) dp[i][j] = -1;
		return matrixMultiplication(1, N-1, arr, dp);
	}

	public static int matrixMultiplication(int i, int j, int[] arr, int[][] dp){
		if(i == j) return 0;
		if(dp[i][j] != -1) return dp[i][j];
		int min = (int) 1e9;
		for(int k=i;k<j;k++){
			int steps = arr[i-1]*arr[k]*arr[j] + 
				matrixMultiplication(i, k, arr, dp) +
				matrixMultiplication(k+1, j, arr, dp);
			min = Math.min(min, steps);
		}
		return dp[i][j] = min;
	}
}

// Tabulation
public class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
		int[][] dp = new int[N][N];

		for(int i=N-1;i>0;i--){
			for(int j=i+1;j<N;j++){
				int min = (int) 1e9;
				for(int k=i;k<j;k++){
					int steps = arr[i-1]*arr[k]*arr[j] + 
						dp[i][k] + dp[k+1][j];
					min = Math.min(min, steps);
				}
				dp[i][j] = min;
			}
		}

		return dp[1][N-1];
	}
}
