// Memoization
public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int[] value = new int[n];
		int target = n;
		for(int i=0;i<n;i++) value[i] = i+1;

		int[][] dp = new int[n][n+1];
		for(int i=0;i<n;i++) for(int j=0;j<=n;j++) dp[i][j] = -1;
		return cutRoad(n-1, value, price, target, dp);
	}

	public static int cutRoad(int index, int[] value, int[] price, int target, int[][] dp){
		if(index == 0) return target*price[0];
		if(dp[index][target] != -1) return dp[index][target];

		int notpick = cutRoad(index-1, value, price, target, dp);
		int pick = (int) -1e9;
		if(value[index] <= target) pick = price[index] + cutRoad(index, value, price, target - value[index], dp);

		return dp[index][target] = Math.max(notpick, pick);

	}
}

//Tabulation
public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int target = n;
		int[] value = new int[n];
		for(int i=0;i<n;i++) value[i] = i+1;

		int[][] dp = new int[n][target+1];

		//base conidition
		for(int i=0;i<=target;i++) dp[0][i] = i*price[0];

		//compute
		for(int i=1;i<n;i++){
			for(int t=0;t<=target;t++){
				int notpick = dp[i-1][t];
				int pick = (int) -1e9;
				if(value[i] <= t) pick = price[i] + dp[i][t - value[i]];
				dp[i][t] = Math.max(notpick, pick);
			}
		}

		return dp[n-1][target];
	}
}

// Space Optimization
public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int target = n;
		int[] value = new int[n];
		for(int i=0;i<n;i++) value[i] = i+1;

		int[] dp = new int[target+1];

		//base conidition
		for(int i=0;i<=target;i++) dp[i] = i*price[0];

		//compute
		for(int i=1;i<n;i++){
			for(int t=0;t<=target;t++){
				int notpick = dp[t];
				int pick = (int) -1e9;
				if(value[i] <= t) pick = price[i] + dp[t - value[i]];
				dp[t] = Math.max(notpick, pick);
			}
		}

		return dp[target];
	}
}
