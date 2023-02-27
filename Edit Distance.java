// Memoization
class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1][l2];
        for(int i=0;i<l1;i++) for(int j=0;j<l2;j++) dp[i][j] = -1; 
        return minDistance(l1-1, l2-1, word1, word2, dp);
    }
    public int minDistance(int index1, int index2, String word1, String word2, int[][] dp){
        //base case
        if(index2 < 0) return index1 + 1;
        if(index1 < 0) return index2 + 1;

        if(dp[index1][index2] != -1) return dp[index1][index2];

        //condition
        if(word1.charAt(index1) == word2.charAt(index2))
            return dp[index1][index2] = minDistance(index1-1, index2-1, word1, word2, dp);

        int insert = 1 + minDistance(index1, index2-1, word1, word2, dp);
        int replace = 1 + minDistance(index1-1, index2-1, word1, word2, dp);
        int delete = 1 + minDistance(index1-1, index2, word1, word2, dp);

        return dp[index1][index2] = Math.min(insert, Math.min(replace, delete));
    }
}

// Tabulation
class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];    

        // base case
        for(int i=0;i<=l1;i++) dp[i][0] = i;
        for(int j=0;j<=l2;j++) dp[0][j] = j;

        //compute
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int insert = 1 + dp[i][j-1];
                    int replace = 1 + dp[i-1][j-1];
                    int delete = 1 + dp[i-1][j];

                    dp[i][j] = Math.min(insert, Math.min(replace, delete));
                }
            }
        }

        return dp[l1][l2];
    }
}

// Space Optimization
class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[] dp = new int[l2+1];

        // base case
        for(int j=0;j<=l2;j++) dp[j] = j;

        //compute
        for(int i=1;i<=l1;i++){
            int[] temp = new int[l2+1];
            temp[0] = i;
            for(int j=1;j<=l2;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    temp[j] = dp[j-1];
                } else {
                    int insert = 1 + temp[j-1];
                    int replace = 1 + dp[j-1];
                    int delete = 1 + dp[j];

                    temp[j] = Math.min(insert, Math.min(replace, delete));
                }
            }
            for(int j=0;j<=l2;j++) dp[j] = temp[j];
        }

        return dp[l2];
    }
}
