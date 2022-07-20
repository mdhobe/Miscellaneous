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
		int[] heights = {2, 1, 5, 6, 2, 3, 1};

		nextGreater(heights);
		nextSmaller(heights);
		previousGreater(heights);
		previousSmaller(heights);

		System.out.println();

		nextGreaterLoop(heights);
		nextSmallerLoop(heights);
		previousGreaterLoop(heights);
		previousSmallerLoop(heights);
	}

	// return next greater element in non-continous series
	public int[] nextGreater(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();

		int[] ans = new int[heights.length];

		for (int i = heights.length - 1; i >= 0; i--) {
			while (!stack.empty() && stack.peek() <= heights[i]) {
				stack.pop();
			}
			if (stack.empty()) ans[i] = -1;
			else ans[i] = stack.peek();
			stack.push(heights[i]);
		}

		print(ans);
		return ans;
	}

	// return previous greater element in non-continous series
	public int[] previousGreater(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();

		int[] ans = new int[heights.length];

		for (int i = 0; i < heights.length; i++) {
			while (!stack.empty() && stack.peek() <= heights[i]) {
				stack.pop();
			}
			if (stack.empty()) ans[i] = -1;
			else ans[i] = stack.peek();
			stack.push(heights[i]);
		}

		print(ans);
		return ans;
	}

	// return previous smaller element in non-continous series
	public int[] previousSmaller(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();

		int[] ans = new int[heights.length];

		for (int i = 0; i < heights.length; i++) {
			while (!stack.empty() && stack.peek() >= heights[i]) {
				stack.pop();
			}
			if (stack.empty()) ans[i] = -1;
			else ans[i] = stack.peek();
			stack.push(heights[i]);
		}

		print(ans);
		return ans;
	}

	// return next smaller element in non-continous series
	public int[] nextSmaller(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();

		int[] ans = new int[heights.length];

		for (int i = heights.length - 1; i >= 0; i--) {
			while (!stack.empty() && stack.peek() >= heights[i]) {
				stack.pop();
			}
			if (stack.empty()) ans[i] = -1;
			else ans[i] = stack.peek();
			stack.push(heights[i]);
		}

		print(ans);
		return ans;
	}

	// return next greater element in continous series
	public int[] nextGreaterLoop(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();

		int[] ans = new int[heights.length];

		for (int i = 2 * heights.length - 1; i >= 0; i--) {
			while (!stack.empty() && stack.peek() <= heights[i % heights.length]) {
				stack.pop();
			}
			if (stack.empty()) ans[i % heights.length] = -1;
			else ans[i % heights.length] = stack.peek();
			stack.push(heights[i % heights.length]);
		}

		print(ans);
		return ans;
	}

	// return next smaller element in continous series
	public int[] nextSmallerLoop(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();

		int[] ans = new int[heights.length];

		for (int i = 2 * heights.length - 1; i >= 0; i--) {
			while (!stack.empty() && stack.peek() >= heights[i % heights.length]) {
				stack.pop();
			}
			if (stack.empty()) ans[i % heights.length] = -1;
			else ans[i % heights.length] = stack.peek();
			stack.push(heights[i % heights.length]);
		}

		print(ans);
		return ans;
	}

	// return previous greater element in continous series
	public int[] previousGreaterLoop(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();

		int[] ans = new int[heights.length];

		for (int i = 0; i < 2 * heights.length; i++) {
			while (!stack.empty() && stack.peek() <= heights[i % heights.length]) {
				stack.pop();
			}
			if (stack.empty()) ans[i % heights.length] = -1;
			else ans[i % heights.length] = stack.peek();
			stack.push(heights[i % heights.length]);
		}

		print(ans);
		return ans;
	}

	// return previous smaller element in continous series
	public int[] previousSmallerLoop(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();

		int[] ans = new int[heights.length];

		for (int i = 0; i < 2 * heights.length; i++) {
			while (!stack.empty() && stack.peek() >= heights[i % heights.length]) {
				stack.pop();
			}
			if (stack.empty()) ans[i % heights.length] = -1;
			else ans[i % heights.length] = stack.peek();
			stack.push(heights[i % heights.length]);
		}

		print(ans);
		return ans;
	}

	public void print(int[] heights) {
		for (int element : heights) System.out.print(element + " ");
		System.out.println();
	}

}
