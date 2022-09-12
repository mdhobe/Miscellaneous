class Solution {
    public int orangesRotting(int[][] grid) {
		if (grid == null || grid.length == 0) return 0;
		int r = grid.length, c = grid[0].length;

		int[][] visited = new int[r][c];
		Queue<int[]> queue = new LinkedList<>();
		int count_fresh = 0;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 2) queue.offer(new int[] {i, j});
				if (grid[i][j] != 0) count_fresh++;
			}
		}

		if (count_fresh == 0) return 0;

		int cnt = 0, ans = 0;
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

		while (!queue.isEmpty()) {
			int size = queue.size();
			cnt += size;
			for (int i = 0; i < size; i++) {
				int[] points = queue.poll();
				for (int j = 0; j < 4; j++) {
					int x = points[0] + dx[j];
					int y = points[1] + dy[j];

					if (x < 0 || y < 0 || x >= r || y >= c || grid[x][y] == 0 || grid[x][y] == 2) continue;

					grid[x][y] = 2;
					queue.offer(new int[] {x, y});
				}
			}
			if (queue.size() > 0) ans++;
		}

		if (count_fresh != cnt) return -1;

		return ans;
	}
}
