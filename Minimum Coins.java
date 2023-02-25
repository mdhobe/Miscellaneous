//Memoization
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(amount == 0) return 0;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<n;i++) for(int j=0;j<=amount;j++) dp[i][j] = -1; 
        int coin = coinChange(n-1,coins, amount,dp);
        return coin == (int) 1e9 ? -1 : coin;
    }

    public int coinChange(int index,int[] coins, int amount, int[][] dp){
        if(index == 0){
            if(amount % coins[0] == 0) return amount / coins[0];
            return (int) 1e9;
        }
        if(dp[index][amount] != -1) return dp[index][amount];

        int pick = (int) 1e9;
        if(coins[index] <= amount) pick = 1 + coinChange(index, coins, amount - coins[index], dp);
        int notpick = coinChange(index-1, coins, amount, dp);

        return dp[index][amount] = Math.min(pick, notpick);
    }
}

//Tabulation
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(amount == 0) return 0;
        int[][] dp = new int[n][amount+1];

        for(int i=0;i<=amount;i++){
            if(i % coins[0] == 0) dp[0][i] =  i / coins[0];
            else dp[0][i] = (int) 1e9;
        }

        for(int i=1;i<n;i++){
            for(int a=0;a<=amount;a++){
                int pick = (int) 1e9;
                if(coins[i] <= a) pick = 1 + dp[i][a - coins[i]];
                int notpick = dp[i-1][a];
                dp[i][a] = Math.min(pick, notpick);
            }
        }

        return dp[n-1][amount] >= (int) 1e9 ? -1 : dp[n-1][amount];
    }
}

// Space Optimization
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];

        for(int i=0;i<=amount;i++){
            if(i % coins[0] == 0) dp[i] =  i / coins[0];
            else dp[i] = (int) 1e9;
        }

        for(int i=1;i<n;i++){
            int[] temp = new int[amount+1];
            for(int a=0;a<=amount;a++){
                int pick = (int) 1e9;
                if(coins[i] <= a) pick = 1 + temp[a - coins[i]];
                int notpick = dp[a];
                temp[a] = Math.min(pick, notpick);
            }
            for(int a=0;a<=amount;a++) dp[a] = temp[a];
        }

        return dp[amount] >= (int) 1e9 ? -1 : dp[amount];
    }
}
