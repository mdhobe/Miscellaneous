// Memoization
class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuffer sbr = new StringBuffer(s);
        sbr.reverse();
        String r = sbr.toString();

        int l1 = s.length(), l2 = r.length();
        int[][] dp = new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++) for(int j=0;j<=l2;j++) dp[i][j] = -1;
        return lcs(l1-1, l2-1, s, r, dp);
    }

    public int lcs(int ind1, int ind2, String s1, String s2, int[][] dp){
        if(ind1 < 0 || ind2 < 0) return 0;
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        if(s1.charAt(ind1) == s2.charAt(ind2)) 
            return dp[ind1][ind2] = 1 + lcs(ind1-1, ind2-1, s1, s2, dp);
        return dp[ind1][ind2] = Math.max(lcs(ind1-1, ind2, s1, s2, dp), lcs(ind1, ind2-1, s1, s2, dp));
    }
}

// Tabulation
class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuffer sbr = new StringBuffer(s);
        sbr.reverse();
        String r = sbr.toString();

        int l1 = s.length(), l2 = r.length();
        int[][] dp = new int[l1+1][l2+1];

        for(int i=0;i<=l1;i++) dp[i][0] = 0;
        for(int i=0;i<=l2;i++) dp[0][i] = 0;

        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s.charAt(i-1) == r.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        } 

        return dp[l1][l2];
    }
}

// Space Optmization
class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuffer sbr = new StringBuffer(s);
        sbr.reverse();
        String r = sbr.toString();

        int l1 = s.length(), l2 = r.length();
        int[] dp = new int[l2+1];

        for(int i=0;i<=l2;i++) dp[i] = 0;

        for(int i=1;i<=l1;i++){
            int[] temp = new int[l2+1];
            for(int j=1;j<=l2;j++){
                if(s.charAt(i-1) == r.charAt(j-1)) temp[j] = 1 + dp[j-1];
                else temp[j] = Math.max(dp[j], temp[j-1]);
            }
            for(int j=1;j<=l2;j++) dp[j] = temp[j];
        } 

        return dp[l2];
    }
}
