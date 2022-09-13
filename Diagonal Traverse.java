class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length;
		int[] ans = new int[n * m];
		int count = 0;

		for (int i = 0; i < n + m - 1; i++) {
			if (i % 2 == 0) {
				//even
				int row = i, col = 0;
				if (i >= n) {
					row = n - 1;
					col = i - row;
				}
				while (col <= m - 1) {
					try {
						ans[count++] = mat[row--][col++];
					} catch (Exception e) {
						count--;
						break;
					}
				}
			} else {
				//odd
				int row = 0, col = i;
				if (i >= m) {
					col = m - 1;
					row = i - col;
				}

				while (row >= 0) {
					try {
						ans[count++] = mat[row++][col--];
					} catch (Exception e) {
						count--;
						break;
					}
				}
			}
		}
        
        return ans;
    }
}
