class Pair {
    int i, j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
		int ans = 0;
		int[][] visited = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') visited[i][j] = 0;
				else if (grid[i][j] == '0') visited[i][j] = 1;
			}
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (visited[i][j] == 0) {
                    Queue<Pair> queue = new LinkedList<>();
                    queue.add(new Pair(i,j));
					dfs(visited, queue);
					ans++;
				}
			}
		}
		return ans;
	}

	public void dfs(int[][] visited, Queue<Pair> queue) {
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pair pair = queue.poll();
                int x = pair.i;
                int y = pair.j;
                visited[x][y] = 1;

                if (y < visited[0].length - 1 && visited[x][y + 1] == 0) {
                    visited[x][y + 1] = 1;
                    queue.add(new Pair(x,y+1));
                }
                if (y > 0 && visited[x][y - 1] == 0) {
                    visited[x][y - 1] = 1;
                    queue.add(new Pair(x,y-1));
                }
                if (x < visited.length - 1 && visited[x + 1][y] == 0) {
                    visited[x + 1][y] = 1;
                    queue.add(new Pair(x+1,y));
                }
                if (x > 0 && visited[x - 1][y] == 0) {
                    visited[x - 1][y] = 1;
                    queue.add(new Pair(x-1,y));
                }
            }
        }
	}
}
// class Solution {
//     public int numIslands(char[][] grid) {
// 		int ans = 0;
// 		int[][] visited = new int[grid.length][grid[0].length];
// 		for (int i = 0; i < grid.length; i++) {
// 			for (int j = 0; j < grid[0].length; j++) {
// 				if (grid[i][j] == '1') visited[i][j] = 0;
// 				else if (grid[i][j] == '0') visited[i][j] = 1;
// 			}
// 		}
// 		for (int i = 0; i < grid.length; i++) {
// 			for (int j = 0; j < grid[0].length; j++) {
// 				if (visited[i][j] == 0) {
// 					dfs(i, j, visited);
// 					ans++;
// 				}
// 			}
// 		}
// 		return ans;
// 	}

// 	public void dfs(int x, int y, int[][] visited) {
// 		visited[x][y] = 1;

// 		if (y < visited[0].length - 1 && visited[x][y + 1] == 0) {
// 			visited[x][y + 1] = 1;
// 			dfs(x, y + 1, visited);
// 		}
// 		if (y > 0 && visited[x][y - 1] == 0) {
// 			visited[x][y - 1] = 1;
// 			dfs(x, y - 1, visited);
// 		}
// 		if (x < visited.length - 1 && visited[x + 1][y] == 0) {
// 			visited[x + 1][y] = 1;
// 			dfs(x + 1, y, visited);
// 		}
// 		if (x > 0 && visited[x - 1][y] == 0) {
// 			visited[x - 1][y] = 1;
// 			dfs(x - 1, y, visited);
// 		}
// 	}
// }
