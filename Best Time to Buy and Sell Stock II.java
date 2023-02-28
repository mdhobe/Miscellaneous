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

// Tabulation
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        
        // for n set 0
        dp[n][0] = 0;
        dp[n][1] = 0;

        // compute
        for(int day=n-1;day>=0;day--){
            for(int state=0;state<2;state++){
                int profit = 0;
                if(state == 1){
                    profit = Math.max(
                        - prices[day] + dp[day+1][0],
                        0 + dp[day+1][1]
                    );
                } else {
                    profit = Math.max(
                        prices[day] + dp[day+1][1],
                        0 + dp[day+1][0]
                    );
                }
                dp[day][state] = profit;
            }
        }

        return dp[0][1];
    }
}

// Space Optimization
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[2];

        // compute
        for(int day=n-1;day>=0;day--){
            int[] temp = new int[2];
            for(int state=0;state<2;state++){
                int profit = 0;
                if(state == 1){
                    profit = Math.max(
                        - prices[day] + dp[0],
                        0 + dp[1]
                    );
                } else {
                    profit = Math.max(
                        prices[day] + dp[1],
                        0 + dp[0]
                    );
                }
                temp[state] = profit;
            }
            for(int state=0;state<2;state++) dp[state] = temp[state];
        }

        return dp[1];
    }
}
