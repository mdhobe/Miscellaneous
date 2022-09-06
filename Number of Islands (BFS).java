class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length;
		int[][] visited = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int a = Character.getNumericValue(grid[i][j]);
				if (a == 0) visited[i][j] = 1;
				else visited[i][j] = 0;
			}
		}

		int count = 0;
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				if (visited[i][j] == 0) {
					count++;
					bfs(i, j, visited, grid);
				}
			}
		}
		return count;
    }
    
    public void bfs(int i, int j, int[][] visited, char[][] grid) {
		Queue<ArrayList<Integer>> queue = new LinkedList<>();

		visited[i][j] = 1;
		ArrayList<Integer> nodes = new ArrayList<>();
		nodes.add(i);
		nodes.add(j);
		queue.add(new ArrayList(nodes));

		while (!queue.isEmpty()) {
			ArrayList<Integer> node = queue.poll();
			int x = node.get(0), y = node.get(1);

			visited[x][y] = 1;

			if (y < visited[0].length - 1 && visited[x][y + 1] == 0) {
				ArrayList<Integer> pos = new ArrayList<>();
				pos.add(x);
				pos.add(y + 1);
				queue.add(pos);
				visited[x][y + 1] = 1;
			}
			if (y > 0 && visited[x][y - 1] == 0) {
				ArrayList<Integer> pos = new ArrayList<>();
				pos.add(x);
				pos.add(y - 1);
				queue.add(pos);
				visited[x][y - 1] = 1;
			}
			if (x < visited.length - 1 && visited[x + 1][y] == 0) {
				ArrayList<Integer> pos = new ArrayList<>();
				pos.add(x + 1);
				pos.add(y);
				queue.add(pos);
				visited[x + 1][y] = 1;
			}
			if (x > 0 && visited[x - 1][y] == 0) {
				ArrayList<Integer> pos = new ArrayList<>();
				pos.add(x - 1);
				pos.add(y);
				queue.add(pos);
				visited[x - 1][y] = 1;
			}
		}
	}
}
