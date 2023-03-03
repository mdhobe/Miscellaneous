// Memoization
import java.util.* ;
import java.io.*; 
public class Solution {
    static int mod = 1000000007;
    public static int evaluateExp(String exp) {
        // Write your code here.
        int length = exp.length();
        int[][][] dp = new int[length][length][2];
        for(int i=0;i<length;i++) for(int j=0;j<length;j++) for(int k=0;k<2;k++) dp[i][j][k] = -1;
        return (int) evaluateExp(0, length-1, exp, 1, dp);
    }

    public static long evaluateExp(int i, int j, String exp, int isTrue, int[][][] dp){
        if(i > j) return 0;
        if(i == j){
            if(exp.charAt(i) == 'T') return isTrue == 1 ? 1 : 0;
            else return isTrue == 0 ? 1 : 0;
        }
        if(dp[i][j][isTrue] != -1) return dp[i][j][isTrue];
        long ways = 0;
        for(int ind=i+1;ind<=j-1;ind+=2){
            long lt = evaluateExp(i, ind-1, exp, 1, dp);
            long lf = evaluateExp(i, ind-1, exp, 0, dp);
            long rt = evaluateExp(ind+1, j, exp, 1, dp);
            long rf = evaluateExp(ind+1, j, exp, 0, dp);

            if(exp.charAt(ind) == '&'){
                if(isTrue == 1){
                    ways = (ways + (lt * rt) % mod)%mod;
                } else {
                    ways = (ways + (lt * rf) % mod + (rt * lf) % mod + (lf * rf) % mod) % mod;
                }
            } else if(exp.charAt(ind) == '|'){
                if(isTrue == 1){
                    ways = (ways + (lt * rf) % mod + (rt * lf) % mod + (lt * rt) % mod) % mod;
                } else {
                    ways = (ways + (lf * rf) % mod)%mod;
                }
            } else if(exp.charAt(ind) == '^'){
                if(isTrue == 1){
                    ways = (ways + (lt * rf) % mod + (rt * lf) % mod) %mod;
                } else {
                    ways = (ways + (lt * rt) % mod + (rf * lf) % mod) %mod;
                }
            }
        }

        return dp[i][j][isTrue] = (int) ways;
    }
}
