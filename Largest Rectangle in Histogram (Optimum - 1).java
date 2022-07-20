import java.io.*;
import java.util.*;

public class C {
	int count = 0;
	public void main() {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		int[] heights = {1, 1};

		System.out.println(largestRectangles(heights));
	}

	public int largestRectangles(int[] heights) {
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();

		int[] right = nextSmaller(heights);
		int[] left = previousSmaller(heights);

		for (int i = 0; i < heights.length; i++) {
			if (max < (right[i] - left[i] + 1) * heights[i]) {
				max = (right[i] - left[i] + 1) * heights[i];
			}
		}

		return max;
	}

	// return previous smaller index in non-continous series
	public int[] previousSmaller(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();

		int[] ans = new int[heights.length];

		for (int i = 0; i < heights.length; i++) {
			while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}
			if (stack.empty()) ans[i] = 0;
			else ans[i] = stack.peek() + 1;
			stack.push(i);
		}
		return ans;
	}

	// return next smaller index in non-continous series
	public int[] nextSmaller(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();

		int[] ans = new int[heights.length];

		for (int i = heights.length - 1; i >= 0; i--) {
			while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}
			if (stack.empty()) ans[i] = heights.length - 1;
			else ans[i] = stack.peek() - 1;
			stack.push(i);
		}
		return ans;
	}

}
