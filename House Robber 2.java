// memoization
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n];

        for(int i=0;i<n;i++) dp[i] = -1;
        int ans1 = maxMoney(n-2, nums, true, dp);
        System.out.println(ans1);

        for(int i=0;i<n;i++) dp[i] = -1;
        int ans2 = maxMoney(n-1, nums, false, dp);
        System.out.println(ans2);
        return Math.max(ans1, ans2);
    }

    public int maxMoney(int index, int[] nums, boolean first, int[] dp){
        if(index == 0 && first) return nums[0];
        if(index < 0 && first) return 0;
        if(index == 1 && !first) return nums[1];
        if(index < 1 && !first) return 0;
        if(dp[index] != -1) return dp[index];

        int pick = nums[index] + maxMoney(index - 2, nums, first, dp);
        int notpick = maxMoney(index - 1, nums, first, dp);
        
        return dp[index] = Math.max(pick, notpick);
    }
}

//tabulation
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int[] dp = new int[n];
        // leaving last
        for(int i=0;i<n;i++) dp[i] = -1;
        dp[0] = nums[0];
        for(int i=1;i<n-1;i++){
            int prev2 = nums[i];
            if(i > 1) prev2 += dp[i - 2];
            int prev = dp[i - 1];
            dp[i] = Math.max(prev, prev2);
        }
        int ans1 = dp[n-2];
        System.out.println(ans1);

        //leaving first
        for(int i=0;i<n;i++) dp[i] = -1;
        dp[1] = nums[1];
        for(int i=2;i<n;i++){
            int prev2 = nums[i];
            if(i > 2) prev2 += dp[i - 2];
            int prev = dp[i - 1];
            dp[i] = Math.max(prev, prev2);
        }
        int ans2 = dp[n-1];
        System.out.println(ans2);

        return Math.max(ans1, ans2);
    }
}

//space optimization
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int prev2 = 0, prev = nums[0];
        
        // leaving last
        for(int i=1;i<n-1;i++){
            int pick = nums[i];
            if(i > 1) pick += prev2;
            int nonpick = prev;
            int curr = Math.max(pick, nonpick);
            prev2 = prev;
            prev = curr;
        }
        int ans1 = prev;
        System.out.println(ans1);

        //leaving first
        prev2 = 0;
        prev = nums[1];
        for(int i=2;i<n;i++){
            int pick = nums[i];
            if(i > 1) pick += prev2;
            int nonpick = prev;
            int curr = Math.max(pick, nonpick);
            prev2 = prev;
            prev = curr;
        }
        int ans2 = prev;
        System.out.println(ans2);

        return Math.max(ans1, ans2);
    }
}
