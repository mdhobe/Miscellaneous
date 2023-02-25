//Memoization
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<n;i++)for(int j=0;j<=amount;j++) dp[i][j] = -1;
        return change(n-1, amount, coins, dp);
    }

    public int change(int index, int amount, int[] coins, int[][] dp){
        if(index == 0){
            if(amount % coins[0] == 0) return 1;
            return 0;
        }
        if(dp[index][amount] != -1) return dp[index][amount];

        int notpick = change(index-1,amount,coins,dp);
        int pick = 0;
        if(coins[index] <= amount) pick = change(index, amount-coins[index], coins,dp);

        return dp[index][amount] = notpick + pick;
    }
}

// Tabulation
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        // base case
        for(int i=0;i<=amount;i++){
            if(i % coins[0] == 0) dp[0][i] = 1;
            else dp[0][i] = 0;
        }

        //loop
        for(int i=1;i<n;i++){
            for(int a=0;a<=amount;a++){
                int notpick = dp[i-1][a];
                int pick = 0;
                if(coins[i] <= a) pick = dp[i][a-coins[i]];
                dp[i][a] = notpick + pick;
            }
        }

        return dp[n-1][amount];
    }
}

// Space Optimization
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];

        // base case
        for(int i=0;i<=amount;i++){
            if(i % coins[0] == 0) dp[i] = 1;
            else dp[i] = 0;
        }

        //loop
        for(int i=1;i<n;i++){
            int[] temp = new int[amount+1];
            for(int a=0;a<=amount;a++){
                int notpick = dp[a];
                int pick = 0;
                if(coins[i] <= a) pick = temp[a-coins[i]];
                temp[a] = notpick + pick;
            }
            for(int a=0;a<=amount;a++) dp[a] = temp[a];
        }

        return dp[amount];
    }
}
