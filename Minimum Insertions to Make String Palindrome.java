// Memoization
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String r = sb.toString();

        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) dp[i][j] = -1; 

        return n - llp(n-1, n-1, s, r, dp);
    }

    public int llp(int index1, int index2, String text1, String text2, int[][] dp) {
        if(index1 < 0 || index2 < 0) return 0;
        if(dp[index1][index2] != -1) return dp[index1][index2];

        if(text1.charAt(index1) == text2.charAt(index2)) 
            return dp[index1][index2] = 1 + llp(index1-1, index2-1, text1, text2, dp);
        return dp[index1][index2] = Math.max(llp(index1-1, index2, text1, text2, dp), llp(index1, index2-1, text1, text2, dp));
    }
}

//Tabulation
// Tabulation
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String r = sb.toString();

        int[][] dp = new int[n+1][n+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == r.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }   
        }

        return n - dp[n][n];
    }
}

//Space Optimization
// Space Optimization
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String r = sb.toString();

        int[] dp = new int[n+1];
        
        for(int i=1;i<=n;i++){
            int[] temp = new int[n+1];
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == r.charAt(j-1)) temp[j] = 1 + dp[j-1];
                else temp[j] = Math.max(dp[j], temp[j-1]);
            }   
            for(int j=1;j<=n;j++) dp[j] = temp[j];
        }

        return n - dp[n];
    }
}
