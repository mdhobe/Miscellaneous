class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i=0;i<m;i++){
            if(grid[i][0] == 1) dfs(i,0,m,n,grid);
            if(grid[i][n-1] == 1) dfs(i,n-1,m,n,grid);
        }
        for(int i=0;i<n;i++){
            if(grid[0][i] == 1) dfs(0,i,m,n,grid);
            if(grid[m-1][i] == 1) dfs(m-1,i,m,n,grid);
        }
        int ans = 0;
        for(int i=0;i<m;i++) for(int j=0;j<n;j++) if(grid[i][j] == 1) ans++;
        return ans;
    }
    public void dfs(int x, int y, int m, int n, int[][] grid){
        grid[x][y] = 0;
        if(x > 0 && grid[x-1][y] == 1) dfs(x-1,y,m,n,grid);
        if(y > 0 && grid[x][y-1] == 1) dfs(x,y-1,m,n,grid);
        if(x < m-1 && grid[x+1][y] == 1) dfs(x+1,y,m,n,grid);
        if(y < n-1 && grid[x][y+1] == 1) dfs(x,y+1,m,n,grid);
    }
}
