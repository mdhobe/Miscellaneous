import java.io.*;
import java.util.*;

public class C {
	public void main() {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}

		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		int col = scan.nextInt();
		int[][] arr = {{1, 4, 9}, {2, 5, 6}, {3, 8, 7}};
		System.out.println(findMedian(arr, row, col));
	}

	public int findMedian(int[][] A, int row, int col) {
		int low = 1;
		int high = 1000000000;
		int n = row, m = col;

		while (low <= high) {
			int mid = (low + high) >> 1;
			int count = 0;
			for (int i = 0; i < n; i++) {
				count += countSmallerThanMid(A[i], mid, col);
			}
			if (count <= (n * m) / 2) low = mid + 1;
			else high = mid - 1;
		}

		return low;
	}

	public int countSmallerThanMid(int[] A, int mid, int n) {
		int l = 0, h = n - 1;
		while (l <= h) {
			int md = (l + h) >> 1;
			if (A[md] <= mid) l = md + 1;
			else h = md - 1;
		}
		return l;
	}

}
