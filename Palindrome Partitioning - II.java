// Memoization
class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for(int i=0;i<n;i++) dp[i] = -1;
        return minCut(0, s, n, dp) - 1;
    }
    public int minCut(int i, String s, int n, int[] dp){
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];

        int min = (int) 1e9;
        for(int j=i;j<n;j++){
            if(isPalindrome(i, s, j)){
                int cost = 1 + minCut(j+1, s, n, dp);
                min = Math.min(min, cost);
            }
        }

        return dp[i] = min;
    }
    public boolean isPalindrome(int i, String s, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

// Tabulation
class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];

        for(int i=n-1;i>=0;i--){
            int min = (int) 1e9;
            for(int j=i;j<n;j++){
                if(isPalindrome(i, s, j)){
                    int cost = 1 + dp[j+1];
                    min = Math.min(min, cost);
                }
            }
            dp[i] = min;
        }

        return dp[0]-1;
    }
    public boolean isPalindrome(int i, String s, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
