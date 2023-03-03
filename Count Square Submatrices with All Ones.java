// Tabulation
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // dp table
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) if(matrix[i][0] == 1) dp[i][0] = 1;
        for(int i=0;i<n;i++) if(matrix[0][i] == 1) dp[0][i] = 1;

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j] == 1) 
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
            }
        }

        int total = 0;
        for(int i=0;i<m;i++) for(int j=0;j<n;j++) total += dp[i][j];
        return total;
    }
}
