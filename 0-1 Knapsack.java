//Memoization
public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
            int[][] dp = new int[n][maxWeight+1];
            for(int i=0;i<n;i++) for(int j=0;j<=maxWeight;j++) dp[i][j] = -1;
            return knapsack(weight, value, n-1, maxWeight, dp);
    }

    static int knapsack(int[] weight, int[] value, int current, int maxWeight, int[][] dp){
        if(current == 0){
            if(weight[current] <= maxWeight) return value[current];
            else return 0;
        }
        if(dp[current][maxWeight] != -1) return dp[current][maxWeight];

        int pick = 0;
        if(weight[current] <= maxWeight) pick = value[current] + knapsack(weight, value, current-1, maxWeight - weight[current], dp);
        int notpick = knapsack(weight, value, current-1, maxWeight, dp);

        return dp[current][maxWeight] = Math.max(pick,notpick);
    }
}

//Tabulation
public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight+1];
        for(int i=weight[0];i<=maxWeight;i++) dp[0][i] = value[0];

        for(int i=1;i<n;i++){
            for(int w=0;w<=maxWeight;w++){
                int pick = 0;
                if(weight[i] <= w) pick = value[i] + dp[i-1][w - weight[i]];
                int notpick = dp[i-1][w];
                dp[i][w] = Math.max(pick, notpick);
            }
        }

        return dp[n-1][maxWeight];
    }
}

//Space Optimization
public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[] dp = new int[maxWeight+1];
        for(int i=weight[0];i<=maxWeight;i++) dp[i] = value[0];

        for(int i=1;i<n;i++){
            int[] temp = new int[maxWeight+1];
            for(int w=0;w<=maxWeight;w++){
                int pick = 0;
                if(weight[i] <= w) pick = value[i] + dp[w - weight[i]];
                int notpick = dp[w];
                temp[w] = Math.max(pick, notpick);
            }
            for(int w=0;w<=maxWeight;w++) dp[w] = temp[w];
        }

        return dp[maxWeight];
    }
}
