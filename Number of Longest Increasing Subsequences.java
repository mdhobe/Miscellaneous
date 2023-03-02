class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        int max = 0;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            count[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j] && dp[i] < dp[j]+1){
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                } else if(nums[i] > nums[j] && dp[i] == dp[j]+1){
                    count[i] += count[j];
                }
            }
            max = Math.max(max, dp[i]);
        }

        int countmax = 0;
        for(int i=0;i<n;i++) if(max == dp[i]) countmax += count[i];

        return countmax;
    }
}
