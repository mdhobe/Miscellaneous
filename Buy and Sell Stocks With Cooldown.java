// Memoization
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i=0;i<n;i++) for(int j=0;j<2;j++) dp[i][j] = -1;
        return maxProfit(0, prices, 1, n, dp);
    }

    public int maxProfit(int day,int[] prices, int state, int n, int[][] dp){
        if(day >= n) return 0;
        if(dp[day][state] != -1) return dp[day][state];
        int profit = 0;
        if(state == 1){
            profit = Math.max(
                -prices[day] + maxProfit(day+1, prices, 0, n, dp),
                0 + maxProfit(day+1, prices, 1, n, dp)
            );
        } else {
            profit = Math.max(
                +prices[day] + maxProfit(day+2, prices, 1, n, dp),
                0 + maxProfit(day+1, prices, 0, n, dp)
            );
        }
        return dp[day][state] = profit;
    }
}

// Tabulation
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        
        for(int day=n-1;day>=0;day--){
            for(int state=0;state<=1;state++){
                int profit = 0;
                if(state == 1){
                    profit = Math.max(
                        -prices[day] + dp[day+1][0],
                        0 + dp[day+1][1]
                    );
                } else {
                    profit = Math.max(
                        +prices[day] + dp[day+2][1],
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
        int[] dp2 = new int[2];
        
        for(int day=n-1;day>=0;day--){
            int[] temp = new int[2];
            for(int state=0;state<=1;state++){
                int profit = 0;
                if(state == 1){
                    profit = Math.max(
                        -prices[day] + dp[0],
                        0 + dp[1]
                    );
                } else {
                    profit = Math.max(
                        +prices[day] + dp2[1],
                        0 + dp[0]
                    );
                }
                temp[state] = profit;
            }
            for(int state=0;state<=1;state++) dp2[state] = dp[state];
            for(int state=0;state<=1;state++) dp[state] = temp[state];
        }

        return dp[1];
    }
}
