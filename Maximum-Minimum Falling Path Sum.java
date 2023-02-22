// Memoization
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int n = matrix.length;
        for(int i=0;i<n;i++){
            int[][] dp = new int[n][n];
            for(int j=0;j<n;j++) for(int k=0;k<n;k++) dp[j][k] = -1;
            ans = Math.min(ans, minFallingPathSum(n-1,i,n,matrix,dp));
        }
        return ans;
    }
    public int minFallingPathSum(int row, int col, int size, int[][] matrix, int[][] dp){
        if(col < 0 || col >= size) return (int) 1e9;
        if(row == 0) return matrix[row][col];
        if(dp[row][col] != -1) return dp[row][col];

        int up = matrix[row][col] + minFallingPathSum(row-1,col-1,size,matrix,dp);
        int left = matrix[row][col] + minFallingPathSum(row-1,col,size,matrix,dp);
        int down = matrix[row][col] + minFallingPathSum(row-1,col+1,size,matrix,dp);

        return dp[row][col] = Math.min(up, Math.min(left, down));
    }
}

//Tabulation
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) dp[0][i] = matrix[0][i];

        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){

                int up = matrix[i][j];
                if(j > 0) up += dp[i-1][j-1];
                else up = (int) 1e9;

                int left = matrix[i][j] + dp[i-1][j];

                int down = matrix[i][j];
                if(j < n-1) down += dp[i-1][j+1];
                else down = (int) 1e9;

                dp[i][j] = Math.min(up, Math.min(left, down));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) ans = Math.min(ans, dp[n-1][i]);
        return ans;
    }
}

// Space Optimization
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++) dp[i] = matrix[0][i];

        for(int i=1;i<n;i++){
            int[] temp = new int[n];
            for(int j=0;j<n;j++){

                int up = matrix[i][j];
                if(j > 0) up += dp[j-1];
                else up = (int) 1e9;

                int left = matrix[i][j] + dp[j];

                int down = matrix[i][j];
                if(j < n-1) down += dp[j+1];
                else down = (int) 1e9;

                temp[j] = Math.min(up, Math.min(left, down));
            }
            for(int j=0;j<n;j++) dp[j] = temp[j];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) ans = Math.min(ans, dp[i]);
        return ans;
    }
}
