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
		int[][] nums = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
		print(setMatrixToZero(nums));
	}

	public int[][] setMatrixToZero(int[][] nums) {
		ArrayList<Integer> rows = new ArrayList<>();
		ArrayList<Integer> cols = new ArrayList<>();

		int m = nums.length;
		int n = nums[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (nums[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}

		System.out.println(rows);
		System.out.println(cols);

		for (int i = 0; i < rows.size(); i++) {
			for (int j = 0; j < n; j++) {
				nums[rows.get(i)][j] = 0;
			}
		}

		for (int i = 0; i < cols.size(); i++) {
			for (int j = 0; j < m; j++) {
				nums[j][cols.get(i)] = 0;
			}
		}

		return nums;
	}

	public void print(int[][] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				System.out.print(nums[i][j] + " ");
			}
			System.out.println();
		}
	}

}
