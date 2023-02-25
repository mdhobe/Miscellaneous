// Memoization
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        int[][] dp = new int[l1][l2];
        for(int i=0;i<l1;i++) for(int j=0;j<l2;j++) dp[i][j] = -1;
        return lcs(l1-1, l2-1, text1, text2, dp);
    }

    public int lcs(int index1, int index2, String text1, String text2, int[][] dp){
        if(index1 < 0 || index2 < 0) return 0;
        if(dp[index1][index2] != -1) return dp[index1][index2];
        if(text1.charAt(index1) == text2.charAt(index2)) 
            return dp[index1][index2] = 1 + lcs(index1-1, index2-1, text1, text2, dp);

        return dp[index1][index2] =  Math.max(lcs(index1-1, index2, text1, text2, dp), lcs(index1, index2-1, text1, text2, dp));
    }
}

// Tabulation
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        int[][] dp = new int[l1+1][l2+1];

        // base case
        for(int i=0;i<=l1;i++) dp[i][0] = 0;
        for(int i=0;i<=l2;i++) dp[0][i] = 0;

        // compute
        for(int s1=1;s1<=l1;s1++){
            for(int s2=1;s2<=l2;s2++){
                if(text1.charAt(s1-1) == text2.charAt(s2-1)) dp[s1][s2] = 1 + dp[s1-1][s2-1];
                else dp[s1][s2] = Math.max(dp[s1-1][s2], dp[s1][s2-1]);
            }
        }

        return dp[l1][l2];
    }
}

// Space Optimization
// Space Optimization
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        int[] dp = new int[l2+1];

        // base case
        for(int i=0;i<=l1;i++) dp[0] = 0;

        // compute
        for(int s1=1;s1<=l1;s1++){
            int[] temp = new int[l2+1];
            for(int s2=1;s2<=l2;s2++){
                if(text1.charAt(s1-1) == text2.charAt(s2-1)) temp[s2] = 1 + dp[s2-1];
                else temp[s2] = Math.max(dp[s2], temp[s2-1]);
            }
            for(int s2=1;s2<=l2;s2++) dp[s2] = temp[s2];
        }

        return dp[l2];
    }
}
