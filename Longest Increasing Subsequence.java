// Memoization
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++) for(int j=0;j<=n;j++) dp[i][j] = -1;
        return lengthOfLIS(1, 0, nums, n, dp);
    }
    public int lengthOfLIS(int current, int prev, int[] nums, int n, int[][] dp) {
        if(current == n+1) return 0;
        if(dp[current][prev] != -1) return dp[current][prev];

        int notpick = 0 + lengthOfLIS(current + 1, prev, nums, n, dp);
        int pick = 0;
        if(prev == 0 || nums[current-1] > nums[prev-1]) 
            pick = 1 + lengthOfLIS(current + 1, current, nums, n, dp);

        return dp[current][prev] = Math.max(notpick, pick);
    }
}

// Tabulation
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for(int current=n-1;current>=0;current--){
            for(int prev=current-1;prev>=-1;prev--){
                int notpick = 0 + dp[current + 1][prev + 1];
                int pick = 0;
                if(prev == -1 || nums[current] > nums[prev]) 
                    pick = 1 + dp[current + 1][current + 1];

                dp[current][prev+1] = Math.max(notpick, pick);
            }
        }

        return dp[0][0];
    }
}

// Space Optimization
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];

        for(int current=n-1;current>=0;current--){
            int[] temp = new int[n+1];
            for(int prev=current-1;prev>=-1;prev--){
                int notpick = 0 + dp[prev + 1];
                int pick = 0;
                if(prev == -1 || nums[current] > nums[prev]) 
                    pick = 1 + dp[current + 1];

                temp[prev+1] = Math.max(notpick, pick);
            }
            for(int prev=0;prev<=n;prev++) dp[prev] = temp[prev];
        }

        return dp[0];
    }
}
