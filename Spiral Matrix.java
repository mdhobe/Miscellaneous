class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
		int n = matrix.length, m = matrix[0].length;
		int i = 0, j = 0;

		int[][] visit = new int[n][m];
		int midrow = n / 2, midcol = m / 2;
		ans.add(matrix[i][j]);
		visit[i][j] = 1;

		while (visit[midrow][midcol] == 0) {
			while (j < m - 1 && visit[i][j + 1] == 0) {
				visit[i][j + 1] = 1; 
				ans.add(matrix[i][j + 1]);
				j++;
			}
			while (i < n - 1 && visit[i + 1][j] == 0) {
				visit[i + 1][j] = 1;
				ans.add(matrix[i + 1][j]);
				i++;
			}
			while (j > 0 && visit[i][j - 1] == 0) {
				visit[i][j - 1] = 1;
				ans.add(matrix[i][j - 1]);
				j--;
			}
			while (i > 0 && visit[i - 1][j] == 0) {
				visit[i - 1][j] = 1;
				ans.add(matrix[i - 1][j]);
				i--;
			}
		}

        return ans;
    }
}
