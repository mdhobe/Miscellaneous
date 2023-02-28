// Memoization
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int i=0;i<n;i++) for(int j=0;j<2;j++) for(int k=0;k<3;k++) dp[i][j][k] = -1;
        return maxProfit(0, prices, 1, 2, n, dp);
    }
    public int maxProfit(int day, int[] prices, int state, int transactions, int n, int[][][] dp) {
        if(transactions == 0) return 0;
        if(day == n) return 0;
        if(dp[day][state][transactions] != -1) return dp[day][state][transactions];
        int profit = 0;
        if(state == 1){
            profit = Math.max(
                -prices[day] + maxProfit(day+1, prices, 0, transactions, n, dp),
                0 + maxProfit(day+1, prices, 1, transactions, n, dp)
            );
        } else {
            profit = Math.max(
                prices[day] + maxProfit(day+1, prices, 1, transactions-1, n, dp),
                0 + maxProfit(day+1, prices, 0, transactions, n, dp)
            );
        }
        return dp[day][state][transactions] = profit;
    }
}

// Tabulation
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

        for(int day=n-1;day>=0;day--){
            for(int state=0;state<2;state++){
                for(int transactions=1;transactions < 3;transactions++){
                    int profit = 0;
                    if(state == 1){
                        profit = Math.max(
                            -prices[day] + dp[day+1][0][transactions],
                            0 + dp[day+1][1][transactions]
                        );
                    } else {
                        profit = Math.max(
                            prices[day] + dp[day+1][1][transactions-1],
                            0 + dp[day+1][0][transactions]
                        );
                    }
                    dp[day][state][transactions] = profit;
                }
            }
        }

        return dp[0][1][2];
    }
}

// Space Optimization
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][3];

        for(int day=n-1;day>=0;day--){
            int[][] temp = new int[2][3];
            for(int state=0;state<2;state++){
                for(int transactions=1;transactions < 3;transactions++){
                    int profit = 0;
                    if(state == 1){
                        profit = Math.max(
                            -prices[day] + dp[0][transactions],
                            0 + dp[1][transactions]
                        );
                    } else {
                        profit = Math.max(
                            prices[day] + dp[1][transactions-1],
                            0 + dp[0][transactions]
                        );
                    }
                    temp[state][transactions] = profit;
                }
            }
            for(int state=0;state<2;state++){
                for(int transactions=0;transactions < 3;transactions++){
                    dp[state][transactions] = temp[state][transactions];
                }
            }
        }

        return dp[1][2];
    }
}
