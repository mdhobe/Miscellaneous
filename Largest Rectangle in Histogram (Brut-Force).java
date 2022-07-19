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
		largestRectangle(0, heights, heights.length, 0);
	}

	public void largestRectangle(int index, int[] heights, int n, int ans) {
		if (index == n) {
			System.out.println(ans);
			return;
		}
		if (ans < heights[index] * (right(index, heights) + left(index, heights) + 1)) {
			ans = heights[index] * (right(index, heights) + left(index, heights) + 1);
		}
		largestRectangle(index + 1, heights, n, ans);
	}

	public int left(int index, int[] heights) {
		for (int i = index; i >= 0; i--) {
			if (i != index && heights[i] < heights[index]) {
				return index - i - 1;
			}
		}
		return index;
	}

	public int right(int index, int[] heights) {
		for (int i = index; i < heights.length; i++) {
			if (i != index && heights[i] < heights[index]) {
				return i - index - 1;
			}
		}
		return heights.length - 1 - index;
	}

}
