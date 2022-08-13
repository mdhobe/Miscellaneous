import java.io.*;
import java.util.*;

public class C {
	int col = 0;
	boolean isAvailable = false;
	public void main() {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}

		Scanner scan = new Scanner(System.in);
		int target = scan.nextInt();
		int[][] array = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		search(array, target);
	}

	public void search(int[][] matrix, int target) {
		binarySearchCol(matrix, target, 0, matrix.length - 1);
		System.out.println(col);
		binarySearchRow(matrix, col, target, 0, matrix[0].length - 1);
		System.out.println(isAvailable);
	}

	public void binarySearchRow(int[][] matrix, int col, int target, int start, int end) {
		if (end >= start) {
			int mid = start + (end - start) / 2;
			if (matrix[col][mid] == target) {
				isAvailable = true;
			} else if (matrix[col][mid] < target) {
				binarySearchRow(matrix, col, target, mid + 1, end);
			} else if (matrix[col][mid] > target) {
				binarySearchRow(matrix, col, target, start, mid - 1);
			}
		}
	}

	public void binarySearchCol(int[][] matrix, int target, int start, int end) {
		int mid = (start + end) / 2;
		if (start == end) {
			col = matrix.length - 1;
		} else {
			if (matrix[mid][0] == target) {
				col = mid;
			} else if (matrix[mid][0] < target) {
				if (matrix[mid][0] == target) {
					col = mid;
				} else if (matrix[mid][0] < target) {
					if (mid < matrix.length - 1 && matrix[mid + 1][0] > target) {
						col = mid;
					} else {
						binarySearchCol(matrix, target, mid + 1, end);
					}
				} else if (matrix[mid][0] > target) {
					if (mid > 0 && matrix[mid - 1][0] < target) {
						col = mid - 1;
					} else {
						binarySearchCol(matrix, target, start, mid);
					}
				}
			}
		}
	}

}
