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
					dfs(i, j, visited);
					ans++;
				}
			}
		}
		return ans;
	}

	public void dfs(int x, int y, int[][] visited) {
		visited[x][y] = 1;

		if (y < visited[0].length - 1 && visited[x][y + 1] == 0) {
			visited[x][y + 1] = 1;
			dfs(x, y + 1, visited);
		}
		if (y > 0 && visited[x][y - 1] == 0) {
			visited[x][y - 1] = 1;
			dfs(x, y - 1, visited);
		}
		if (x < visited.length - 1 && visited[x + 1][y] == 0) {
			visited[x + 1][y] = 1;
			dfs(x + 1, y, visited);
		}
		if (x > 0 && visited[x - 1][y] == 0) {
			visited[x - 1][y] = 1;
			dfs(x - 1, y, visited);
		}
	}
}
