//memoization
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++) dp[i] = -1;
        int ans = maxMoney(n-1, nums, dp);
        return ans;
    }

    public int maxMoney(int index, int[] nums, int[] dp){
        if(index == 0) return nums[0];
        if(index < 0) return 0;
        if(dp[index] != -1) return dp[index];

        int pick = nums[index] + maxMoney(index - 2, nums,  dp);
        int notpick = maxMoney(index - 1, nums, dp);
        
        return dp[index] = Math.max(pick, notpick);
    }
}

//tabulation
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        int curr = nums[0];

        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i > 1) pick += prev2;
            int notpick = prev;
            curr = Math.max(pick, notpick);
            prev2 = prev;
            prev = curr;
        }

        return curr;
    }
}
