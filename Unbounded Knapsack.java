// Memoization
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        int[][] dp = new int[n][w+1];
        for(int i=0;i<n;i++) for(int j=0;j<=w;j++) dp[i][j] = -1;
        return unboundedKnapsack(n-1, w, profit, weight, dp);
    }
    public static int unboundedKnapsack(int index, int w, int[] profit, int[] weight, int[][] dp){
        if(index == 0){
            if(weight[index] <= w) return (w / weight[index]) * profit[index];
            return 0;
        }
        if(dp[index][w] != -1) return dp[index][w];

        int notpick = unboundedKnapsack(index-1, w, profit, weight, dp);
        int pick = 0;
        if(weight[index] <= w) pick = profit[index] + unboundedKnapsack(index, w - weight[index], profit, weight, dp);

        return dp[index][w] = Math.max(notpick, pick);
    }
}

// Tabulation
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        int[][] dp = new int[n][w+1];

        //base condition
        for(int i=0;i<=w;i++){
            if(weight[0] <= i) dp[0][i] = (i / weight[0]) * profit[0];
            else dp[0][i] = 0;
        }

        //compute
        for(int i=1;i<n;i++){
            for(int wt=0;wt<=w;wt++){
                int notpick = dp[i-1][wt];
                int pick = 0;
                if(weight[i] <= wt) pick = profit[i] + dp[i][wt - weight[i]];
                dp[i][wt] = Math.max(pick, notpick);
            }
        }

        return dp[n-1][w];
    }
}

//Space Optimization
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        int[] dp = new int[w+1];

        //base condition
        for(int i=0;i<=w;i++){
            if(weight[0] <= i) dp[i] = (i / weight[0]) * profit[0];
            else dp[i] = 0;
        }

        //compute
        for(int i=1;i<n;i++){
            int[] temp = new int[w+1];
            for(int wt=0;wt<=w;wt++){
                int notpick = dp[wt];
                int pick = 0;
                if(weight[i] <= wt) pick = profit[i] + temp[wt - weight[i]];
                temp[wt] = Math.max(pick, notpick);
            }
            for(int wt=0;wt<=w;wt++) dp[wt] = temp[wt];
        }

        return dp[w];
    }
}
