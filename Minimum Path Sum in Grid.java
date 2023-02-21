// Memoization
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) for(int j=0;j<n;j++) dp[i][j] = -1;
        return minPathSum(m-1, n-1, grid, dp);
    }

    public int minPathSum(int row, int col, int[][] grid, int[][] dp){
        if(row == 0 && col == 0) return grid[row][col];
        if(row < 0 || col < 0) return (int) 1e9;
        if(dp[row][col] != -1) return dp[row][col];

        int left = grid[row][col] + minPathSum(row, col-1, grid, dp);
        int up = grid[row][col] + minPathSum(row-1, col, grid, dp);

        return dp[row][col] = Math.min(left,up);
    }
}

//Tabulation
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        dp[0][0] = grid[0][0];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 && j == 0) dp[i][j] = grid[i][j];
                else{
                    int left = 0, up = 0;

                    if(j > 0) left = grid[i][j] + dp[i][j-1];
                    else left = (int) 1e9;

                    if(i > 0) up = grid[i][j] + dp[i-1][j];
                    else up = (int) 1e9;

                    dp[i][j] = Math.min(left, up);
                }
            }
        }

        return dp[m-1][n-1];
    }
}

//Space Optimization
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        
        for(int i=0;i<m;i++){
            int[] temp = new int[n];
            for(int j=0;j<n;j++){
                if(i == 0 && j == 0) temp[j] = grid[i][j];
                else{
                    int left = 0, up = 0;

                    if(j > 0) left = grid[i][j] + temp[j-1];
                    else left = (int) 1e9;

                    if(i > 0) up = grid[i][j] + dp[j];
                    else up = (int) 1e9;

                    temp[j] = Math.min(left, up);
                }
            }
            for(int j=0;j<n;j++) dp[j] = temp[j];
        }

        return dp[n-1];
    }
}
