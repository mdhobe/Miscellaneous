class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int max = 0;
        int[] a = new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == '1') a[j]++;
                else a[j] = 0;
            }
            int area = largestRectangles(a);
            System.out.println(area);
            max = Math.max(max, area);
        }
        return max;
    }

    public int largestRectangles(int[] heights) {
		int n = heights.length;
		int[] l = left(heights);
		int[] r = right(heights);
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, (r[i] - l[i] + 1) * heights[i]);
		}
		return max;
	}

	public int[] left(int[] heights) {
		int n = heights.length;
		int[] ans = new int[n];

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			if (stack.isEmpty()) {
				ans[i] = 0;
			} else if (heights[stack.peek()] < heights[i]) {
				ans[i] = stack.peek() + 1;
			} else {
				while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
				if (stack.isEmpty()) ans[i] = 0;
				else {
					ans[i] = stack.peek() + 1;
				}
			}
			stack.push(i);
		}

		return ans;
	}

	public int[] right(int[] heights) {
		int n = heights.length;
		int[] ans = new int[n];

		Stack<Integer> stack = new Stack<>();

		for (int i = n - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				ans[i] = n - 1;
			} else if (heights[stack.peek()] < heights[i]) {
				ans[i] = stack.peek() - 1;
			} else {
				while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
				if (stack.isEmpty()) ans[i] = n - 1;
				else {
					ans[i] = stack.peek() - 1;
				}
			}
			stack.push(i);
		}

		return ans;
	}
}
