// Memoization
class Solution {
    public boolean isMatch(String s, String p) {
        int l1 = s.length(), l2 = p.length();
        int[][] dp = new int[l1][l2];
        for(int i=0;i<l1;i++) for(int j=0;j<l2;j++) dp[i][j] = -1;
        return isMatch(l1-1, l2-1, s, p, dp);
    }
    public boolean isMatch(int index1, int index2, String s, String p, int[][] dp){
        if(index1 < 0 && index2 < 0) return true;
        if(index1 >= 0 && index2 < 0) return false;
        if(index1 < 0 && index2 >= 0) {
            for(int i=0;i<=index2;i++) if(p.charAt(i) != '*') return false;
            return true;
        }
        if(dp[index1][index2] != -1) return dp[index1][index2] == 1 ? true : false;
        if(s.charAt(index1) == p.charAt(index2) || p.charAt(index2) == '?'){
            boolean result = isMatch(index1-1, index2-1, s, p, dp);
            dp[index1][index2] = result ? 1 : 0;
            return result;
        }
        if(p.charAt(index2) == '*'){
            boolean result = isMatch(index1, index2-1, s, p, dp) || isMatch(index1-1, index2, s, p, dp);
            dp[index1][index2] = result ? 1 : 0;
            return result;
        }
        dp[index1][index2] = 0;
        return false;
    }
}

// Tabulation
class Solution {
    public boolean isMatch(String s, String p) {
        int l1 = s.length(), l2 = p.length();
        boolean[][] dp = new boolean[l1+1][l2+1];

        //base condition
        dp[0][0] = true;
        for(int j=1;j<=l2;j++){
            if(p.charAt(j-1) != '*') dp[0][j] = false;
            else dp[0][j] = true;
        }

        //compute
        for(int index1=1;index1<=l1;index1++){
            for(int index2=1;index2<=l2;index2++){
                if(s.charAt(index1-1) == p.charAt(index2-1) || p.charAt(index2-1) == '?'){
                    dp[index1][index2] = dp[index1-1][index2-1];
                } else if(p.charAt(index2-1) == '*'){
                    dp[index1][index2] = dp[index1][index2-1] || dp[index1-1][index2];
                } else dp[index1][index2] = false;
            }
        }

        return dp[l1][l2];
    }
}
