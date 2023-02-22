// Memoization
class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for(int i=0;i<m;i++) for(int j=0;j<n;j++) for(int k=0;k<n;k++) dp[i][j][k] = -1;
        return cherryPickup(0,0,n-1,grid,n,m,dp);
    }

    public int cherryPickup(int row, int col1, int col2, int[][] grid, int n, int m,int[][][] dp){
        if(col1 < 0 || col1 >= n || col2 < 0 || col2 >= n) return (int) -1e8;
        if(row == m-1){
            if(col1 == col2) return grid[row][col1];
            else return grid[row][col1] + grid[row][col2];
        }
        if(dp[row][col1][col2] != -1) return dp[row][col1][col2];

        int ans = (int) -1e8;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int val = 0;
                if(col1 == col2){
                    val = grid[row][col2];
                } else {
                    val = grid[row][col1] + grid[row][col2];
                }
                val += cherryPickup(row+1,col1+i,col2+j,grid,n,m,dp);
                ans = Math.max(ans, val);
            }
        }

        return dp[row][col1][col2] = ans;
    }
}

//Tabulation
class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        int[][][] dp = new int[rows][cols][cols];
        //base case
        for(int i=0;i<cols;i++) {
            for(int j=0;j<cols;j++){
                if(i == j) dp[rows-1][i][j] = grid[rows-1][i];
                else dp[rows-1][i][j] = grid[rows-1][i] + grid[rows-1][j];
            }
        }

        for(int row = rows-2;row>=0;row--){
            for(int col1 = 0;col1 < cols;col1++){
                for(int col2 = 0;col2 < cols;col2++){
                    int ans = (int) -1e9;
                    for(int i=-1;i<=1;i++){
                        for(int j=-1;j<=1;j++){
                            int val = 0;
                            if(col1 == col2){
                                val = grid[row][col2];
                            } else {
                                val = grid[row][col1] + grid[row][col2];
                            }
                            if(col1+i<0||col1+i>=cols||col2+j<0||col2+j>=cols) val = (int) -1e9;
                            else val += dp[row+1][col1+i][col2+j];
                            ans = Math.max(ans, val);
                        }
                    }
                    dp[row][col1][col2] = ans;
                }
            }
        }

        return dp[0][0][cols-1];

    }
}

//Space Optimization
//Space Optimization
class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        int[][] dp = new int[cols][cols];
        //base case
        for(int i=0;i<cols;i++) {
            for(int j=0;j<cols;j++){
                if(i == j) dp[i][j] = grid[rows-1][i];
                else dp[i][j] = grid[rows-1][i] + grid[rows-1][j];
            }
        }

        for(int row = rows-2;row>=0;row--){
            int[][] temp = new int[cols][cols];
            for(int col1 = 0;col1 < cols;col1++){
                for(int col2 = 0;col2 < cols;col2++){
                    int ans = (int) -1e9;
                    for(int i=-1;i<=1;i++){
                        for(int j=-1;j<=1;j++){
                            int val = 0;
                            if(col1 == col2){
                                val = grid[row][col2];
                            } else {
                                val = grid[row][col1] + grid[row][col2];
                            }
                            if(col1+i<0||col1+i>=cols||col2+j<0||col2+j>=cols) val = (int) -1e9;
                            else val += dp[col1+i][col2+j];
                            ans = Math.max(ans, val);
                        }
                    }
                    temp[col1][col2] = ans;
                }
            }
            for(int i=0;i<cols;i++) for(int j=0;j<cols;j++) dp[i][j] = temp[i][j];
        }

        return dp[0][cols-1];

    }
}
