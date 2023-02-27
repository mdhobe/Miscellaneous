// Memoization
class Solution {
    public int numDistinct(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        int[][] dp = new int[l1][l2];
        for(int i=0;i<l1;i++) for(int j=0;j<l2;j++) dp[i][j] = -1;
        return numDistinct(l1-1, l2-1, s, t, dp);
    }

    public int numDistinct(int index1, int index2, String s, String t, int[][] dp){
        if(index2 < 0) return 1;
        if(index1 < 0) return 0;
        if(dp[index1][index2] != -1) return dp[index1][index2];
        if(s.charAt(index1) == t.charAt(index2))
            return dp[index1][index2] = numDistinct(index1-1, index2-1, s, t, dp) + numDistinct(index1-1, index2, s, t, dp);
        return dp[index1][index2] = numDistinct(index1-1, index2, s, t, dp);
    }
}

//Tabulation
class Solution {
    public int numDistinct(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        int[][] dp = new int[l1+1][l2+1];

        //base case
        for(int j=0;j<=l2;j++) dp[0][j] = 0;
        for(int i=0;i<=l1;i++) dp[i][0] = 1;

        //compute
        for(int index1=1;index1<=l1;index1++){
            for(int index2=1;index2<=l2;index2++){
                if(s.charAt(index1-1) == t.charAt(index2-1)) 
                    dp[index1][index2] = dp[index1-1][index2-1] + dp[index1-1][index2];
                else dp[index1][index2] = dp[index1-1][index2];
            }
        }

        return dp[l1][l2];
    }
}

// Space Optimization
class Solution {
    public int numDistinct(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        int[] dp = new int[l2+1];

        //base case
        dp[0] = 1;

        //compute
        for(int index1=1;index1<=l1;index1++){
            int[] temp = new int[l2+1];
            for(int index2=1;index2<=l2;index2++){
                if(s.charAt(index1-1) == t.charAt(index2-1)) 
                    temp[index2] = dp[index2-1] + dp[index2];
                else temp[index2] = dp[index2];
            }
            for(int index2=1;index2<=l2;index2++) dp[index2] = temp[index2];
        }

        return dp[l2];
    }
}
