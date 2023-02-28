// Memoization
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i=0;i<n;i++) for(int j=0;j<2;j++) dp[i][j] = -1;
        return maxProfit(0, prices, 1, n, dp);
    }

    public int maxProfit(int current, int[] prices, int state, int n, int[][] dp) {
        if(current == n) return 0;
        if(dp[current][state] != -1) return dp[current][state];
        int profit = 0;
        if(state == 1){
            profit = Math.max(
                -prices[current] + maxProfit(current+1, prices, 0, n, dp),
                0 + maxProfit(current+1, prices, 1, n, dp)
            );
        } else {
            profit = Math.max(
                prices[current] + maxProfit(current+1, prices, 1, n, dp),
                0 + maxProfit(current+1, prices, 0, n, dp)
            );
        }
        return dp[current][state] = profit;
    }
}
