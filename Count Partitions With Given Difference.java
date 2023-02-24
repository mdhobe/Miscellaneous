//Memoization
public class Solution {
	static int mod = (int) 1e9+7;
	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		int total = 0;
		for(int a : arr) total += a;
		if(total - d < 0 || (total - d)%2 != 0) return 0;
		int target = (total - d)/2;
		int[][] dp = new int[n][target+1];
		for(int i=0;i<n;i++) for(int j=0;j<=target;j++) dp[i][j] = -1;

		return findWays(arr, target);
	}

	public static int findWays(int num[], int tar) {
        // Write your code here..
        int n = num.length;
        int[][] dp = new int[n][tar+1];
        for(int i=0;i<n;i++) for(int j=0;j<=tar;j++) dp[i][j] = -1;
        
        return findWays(n-1, num, tar, dp);
    }

    public static int findWays(int current,int num[], int target, int[][] dp){
        if(current == 0){
            if(target == 0 && num[0] == 0) return 2;
            if(target == 0 || target == num[0]) return 1;
            return 0;
        }
        if(dp[current][target] != -1) return dp[current][target];

        int pick = 0;
        if(num[current] <= target) pick = findWays(current-1, num, target - num[current],dp);
        int notpick = findWays(current-1, num, target,dp);

        return dp[current][target] = (pick + notpick) % mod;
    }
}

//Tabulation
public class Solution {
	static int mod = (int) 1e9+7;
	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		int total = 0;
		for(int a : arr) total += a;
		if(total - d < 0 || (total - d)%2 != 0) return 0;
		int target = (total - d)/2;
		int[][] dp = new int[n][target+1];
		for(int i=0;i<n;i++) for(int j=0;j<=target;j++) dp[i][j] = -1;

		return findWays(arr, target);
	}

	public static int findWays(int num[], int tar) {
        // Write your code here..
        int n = num.length;
        int[][] dp = new int[n][tar+1];

        //target = 0
        for(int i=0;i<n;i++){
            if(num[i] == 0) dp[i][0] = 2;
            else dp[i][0] = 1;
        }
        if(num[0] <= tar){
            if(num[0] == 0) dp[0][num[0]] = 2;
            else dp[0][num[0]] = 1;
        }

        //compute
        for(int i=1;i<n;i++){
            for(int t=0;t<=tar;t++){
                int notpick = dp[i-1][t];
                int pick = 0;
                if(num[i] <= t) pick = dp[i-1][t-num[i]];
                dp[i][t] = pick + notpick;
            }
        }

        return dp[n-1][tar];
    }
}

//Space Optimization
public class Solution {
	static int mod = (int) 1e9+7;
	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		int total = 0;
		for(int a : arr) total += a;
		if(total - d < 0 || (total - d)%2 != 0) return 0;
		int target = (total - d)/2;
		int[][] dp = new int[n][target+1];
		for(int i=0;i<n;i++) for(int j=0;j<=target;j++) dp[i][j] = -1;

		return findWays(arr, target);
	}

	public static int findWays(int num[], int tar) {
        // Write your code here..

        //target = 0
        int n = num.length;
        int[] dp = new int[tar+1];

        //target = 0
        dp[0] = 1;
        if(num[0] <= tar){
            if(num[0] == 0)dp[num[0]] = 2;
            else dp[num[0]] = 1;
        }

        //compute
        for(int i=1;i<n;i++){
            int[] temp = new int[tar+1];
            for(int t=0;t<=tar;t++){
                int notpick = dp[t];
                int pick = 0;
                if(num[i] <= t) pick = dp[t-num[i]];
                temp[t] = pick + notpick;
            }
            for(int t=0;t<=tar;t++) dp[t] = temp[t];
        }

        return dp[tar];
    }
}
