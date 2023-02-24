//Memoization
class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        int length = nums.length;
        //target check if odd
        for(int n:nums) target += n;
        if(target %2 == 1) return false;

        //dp to -1
        int[][] dp = new int[length][target+1];
        for(int i=0;i<length;i++) for(int j=0;j<=target; j++) dp[i][j] = -1;

        return canPartition(length-1, target/2, nums, dp);
    }

    public boolean canPartition(int ind, int target, int[] nums, int[][] dp){
        if(target == 0) return true;
        if(ind == 0) return (nums[ind] == target);
        if(dp[ind][target] != -1) return (dp[ind][target] == 1);

        boolean nottake = canPartition(ind-1, target, nums, dp);
        boolean take = false;
        if(target >= nums[ind]) take = canPartition(ind-1, target - nums[ind], nums, dp);
        dp[ind][target] = (nottake | take == true ? 1 : 0);

        return nottake | take;
    }
}

//Tabulation
class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        int length = nums.length;

        //target check if odd
        for(int n:nums) target += n;
        if(target %2 == 1) return false;

        target = target/2;

        //dp to false
        boolean[][] dp = new boolean[length][target+1];
        for(int i=0;i<length;i++) dp[i][0] = true;
        if(nums[0] <= target) dp[0][nums[0]] = true;

        for(int ind=1;ind<length;ind++){
            for(int j=1;j<=target;j++){
                boolean nottake = dp[ind-1][j];
                boolean take = false;
                if(j >= nums[ind]) take = dp[ind-1][j - nums[ind]];
                dp[ind][j] = take | nottake;
            }
        }

        return dp[length-1][target];
    }
}

//Space Optimization
class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        int length = nums.length;

        //target check if odd
        for(int n:nums) target += n;
        if(target %2 == 1) return false;

        target = target/2;

        //dp to false
        boolean[] dp = new boolean[target+1];
        boolean[] temp = new boolean[target+1];
        dp[0] = temp[0] = true;

        for(int ind=1;ind<length;ind++){
            for(int j=1;j<=target;j++){
                boolean nottake = dp[j];
                boolean take = false;
                if(j >= nums[ind]) take = dp[j - nums[ind]];
                temp[j] = take | nottake;
            }
            for(int j=0;j<=target;j++) dp[j] = temp[j];
        }

        return dp[target];
    }
}
