class Pair {
    int x, y;
    Pair(int i, int j){
        x = i;
        y = j;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int empty = 0;
        for(int i=0;i<m;i++) for(int j=0;j<n;j++) if(grid[i][j] == 0) empty++;
        if(empty == m*n) return 0;
        int[][] score = new int[m][n];
        for(int i=0;i<m;i++) for(int j=0;j<n;j++) score[i][j] = -1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    score[i][j] = 0;
                    bfs(i,j,m,n,grid,score);
                }
            }
        }
        int ans = -1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans = Math.max(ans, score[i][j]);
                if(score[i][j] == -1 && grid[i][j] == 1) return -1;
            }
        }
        return ans;
    }

    public void bfs(int k, int g, int m, int n, int[][] grid, int[][] score){
        int[][] visited = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();
        visited[k][g] = 1;
        queue.add(new Pair(k, g));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pair p = queue.poll();
                int x = p.x, y = p.y;
                if(x > 0 && visited[x-1][y] == 0 && grid[x-1][y] == 1){
                    if(score[x-1][y] == -1){
                        score[x-1][y] = score[x][y] + 1;
                        queue.add(new Pair(x-1,y));
                        visited[x-1][y] = 1;
                    } else if(score[x-1][y] > score[x][y]) {
                        score[x-1][y] = score[x][y] + 1;
                        queue.add(new Pair(x-1,y));
                        visited[x-1][y] = 1;
                    }
                }
                if(y > 0 && visited[x][y-1] == 0 && grid[x][y-1] == 1){
                    if(score[x][y-1] == -1){
                        score[x][y-1] = score[x][y] + 1;
                        queue.add(new Pair(x,y-1));
                        visited[x][y-1] = 1;
                    } else if(score[x][y-1] > score[x][y]) {
                        score[x][y-1] = score[x][y] + 1;
                        queue.add(new Pair(x,y-1));
                        visited[x][y-1] = 1;
                    }
                }
                if(x < m-1 && visited[x+1][y] == 0 && grid[x+1][y] == 1){
                    if(score[x+1][y] == -1){
                        score[x+1][y] = score[x][y] + 1;
                        queue.add(new Pair(x+1,y));
                        visited[x+1][y] = 1;
                    } else if(score[x+1][y] > score[x][y]) {
                        score[x+1][y] = score[x][y] + 1;
                        queue.add(new Pair(x+1,y));
                        visited[x+1][y] = 1;
                    }
                }
                if(y < n-1 && visited[x][y+1] == 0 && grid[x][y+1] == 1){
                    if(score[x][y+1] == -1){
                        score[x][y+1] = score[x][y] + 1;
                        queue.add(new Pair(x,y+1));
                        visited[x][y+1] = 1;
                    } else if(score[x][y+1] > score[x][y]) {
                        score[x][y+1] = score[x][y] + 1;
                        queue.add(new Pair(x,y+1));
                        visited[x][y+1] = 1;
                    }
                }
            }
        }
    }
}
