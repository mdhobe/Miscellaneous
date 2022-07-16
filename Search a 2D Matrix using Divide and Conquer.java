import java.io.*;
import java.util.*;

public class C {
	HashMap<Integer, Double> cache = new HashMap<Integer, Double>();
	public void main() {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}

		Scanner scan = new Scanner(System.in);
		int target = scan.nextInt();
		int[][] array = {
			{ -1, 3}
		};
		System.out.println(findIn2dmatrix(array, target));
	}

	public boolean findIn2dmatrix(int[][] array, int target) {

		for (int[] row : array) {
			if (row[0] <= target && target <= row[row.length - 1]) {
				if (binarysearch(row, target, 0, row.length - 1)) return true;
			}
		}

		return false;
	}

	public boolean binarysearch(int[] row, int target, int start, int end) {
		if (end == start) {
			return row[start] == target;
		}

		int mid = (end - start) / 2 + start;

		if (row[mid] >= target) {
			return binarysearch(row, target, start, mid);
		}

		return binarysearch(row, target, mid + 1, end);
	}

}
