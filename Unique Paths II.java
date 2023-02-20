// Memoization
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[rows-1][cols-1] == 1) return 0;
        int[][] dp = new int[rows][cols];
        for(int i=0;i<rows;i++) for(int j=0;j<cols;j++) dp[i][j] = -1;
        return uniquePathsWithObstacles(rows-1, cols-1, obstacleGrid, dp);
    }

    public int uniquePathsWithObstacles(int row, int col,int[][] obstacleGrid, int[][] dp) {
        if(row == 0 && col == 0) return 1;
        if(row < 0 || col < 0) return 0;
        if(obstacleGrid[row][col] == 1) return 0;
        if(dp[row][col] != -1) return dp[row][col];

        int left = uniquePathsWithObstacles(row, col-1, obstacleGrid, dp);
        int up = uniquePathsWithObstacles(row-1, col, obstacleGrid, dp);

        return dp[row][col] = left + up;
    }
}

// Tabulation
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[rows-1][cols-1] == 1) return 0;
        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i == 0 && j == 0) dp[i][j] = 1;
                else if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else {
                    int left = 0, up = 0;
                    if(i > 0) left = dp[i-1][j];
                    if(j > 0) up = dp[i][j-1];
                    dp[i][j] = left + up;
                }
            }
        }

        return dp[rows-1][cols-1];
    }
}

//Space Optimization
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[rows-1][cols-1] == 1) return 0;

        int[] dp = new int[cols];

        for(int i=0;i<rows;i++){
            int[] temp = new int[cols];
            for(int j=0;j<cols;j++){
                if(i == 0 && j == 0) temp[j] = 1;
                else if(obstacleGrid[i][j] == 1) temp[j] = 0;
                else {
                    int left = 0, up = 0;
                    if(j > 0) left = temp[j-1];
                    if(i > 0) up = dp[j];
                    temp[j] = left + up;
                }
            }
            for(int j=0;j<cols;j++) dp[j] = temp[j];
        }

        return dp[cols-1];
    }
}
