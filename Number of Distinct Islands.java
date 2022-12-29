class Solution {
    HashSet<ArrayList<Integer>> set = new HashSet<>();
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    //System.out.println(i + " " + j);
                    ArrayList<Integer> ans = new ArrayList<>();
                    dfs(i,j,m,n,i,j,visited,ans, grid);
                    set.add(ans);
                }
            }
        }
        //System.out.println(set);
        return set.size();
    }
    void dfs(int x, int y, int m, int n,int basei, int basej, boolean[][] visited, ArrayList<Integer> ans,int[][] grid){
        visited[x][y] = true;
        ans.add(x-basei);
        ans.add(y-basej);
        if(x > 0 && !visited[x-1][y] && grid[x-1][y] == 1) dfs(x-1,y,m,n,basei,basej,visited,ans,grid);
        if(y > 0 && !visited[x][y-1] && grid[x][y-1] == 1) dfs(x,y-1,m,n,basei,basej,visited,ans,grid);
        if(x < m-1 && !visited[x+1][y] && grid[x+1][y] == 1) dfs(x+1,y,m,n,basei,basej,visited,ans,grid);
        if(y < n-1 && !visited[x][y+1] && grid[x][y+1] == 1) dfs(x,y+1,m,n,basei,basej,visited,ans,grid);
    }
}
