// Memoization
import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int dp[][] = new int[n+1][k+1];
        for(int i=0;i<n+1;i++) for(int j=0;j<k+1;j++) dp[i][j] = -1;
        return subsetSum(n-1,k,arr,dp);
    }

    public static boolean subsetSum(int current, int target, int arr[],int dp[][]){
        if(target == 0) return true;
        if(target < 0 || current < 0) return false;
        if(dp[current][target] != -1) return dp[current][target] == 1 ? true : false;

        boolean pick = subsetSum(current-1, target - arr[current], arr,dp);
        boolean notpick = subsetSum(current-1, target, arr,dp);
        boolean result = pick || notpick;
        if(result) dp[current][target] = 1;
        else dp[current][target] = 0;
        return result;
    }
}

//Tabulation
import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int target, int arr[]){
        // Write your code here.
        boolean dp[][] = new boolean[n][target+1];
        for(int i=0;i<n;i++) dp[i][0] = true;
        if(arr[0] <= target) dp[0][arr[0]] = true;

        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                boolean nottake = dp[i-1][j];
                boolean take = false;
                if(arr[i] <= j) take = dp[i-1][j-arr[i]];
                dp[i][j] = nottake | take;
            }
        }

        return dp[n-1][target];
    }
}

//Space Optimization
import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int target, int arr[]){
        // Write your code here.
        boolean prev[] = new boolean[target+1];
        boolean current[] = new boolean[target+1];
        prev[0] = current[0] = true;
        if(arr[0] <= target) prev[arr[0]] = true;

        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                boolean nottake = prev[j];
                boolean take = false;
                if(arr[i] <= j) take = prev[j-arr[i]];
                current[j] = nottake | take;
            }
            for(int j=1;j<=target;j++) prev[j] = current[j];
        }

        return prev[target];
    }
}
