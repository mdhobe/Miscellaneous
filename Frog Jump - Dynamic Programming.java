// Using Memoisation
public class Solution {
    public static int f(int n, int[] heights, int[] dp){
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        int left = f(n-1, heights, dp) + Math.abs(heights[n] - heights[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1) right = f(n-2, heights, dp) + Math.abs(heights[n] - heights[n-2]);
        return dp[n] = Math.min(left, right);
    }
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int[] dp = new int[n];
        for(int i=0;i<n;i++) dp[i] = -1;
        return f(n-1, heights, dp);
    }

}

//using Tabulation
public class Solution {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            int first = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            int second = Integer.MAX_VALUE;
            if(i > 1) second = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
            dp[i] = Math.min(first, second);
        }
        return dp[n-1];
    }

}

//using space optimization
public class Solution {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int ans1 = 0, ans2 = 0;
        for(int i=1;i<n;i++){
            int second = Integer.MAX_VALUE;
            if(i > 1){
                second = ans2 + Math.abs(heights[i] - heights[i-2]);
                ans2 = ans1;
            }
            int first = ans1 + Math.abs(heights[i] - heights[i-1]);
            ans1 = Math.min(first, second);
        }
        return ans1;
    }

}
