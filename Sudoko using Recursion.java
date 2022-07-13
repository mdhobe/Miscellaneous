import java.io.*;
import java.util.*;

public class B {
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] array = {
			{3, 0, 6, 5, 0, 8, 4, 0, 0},
			{5, 2, 0, 0, 0, 0, 0, 0, 0},
			{0, 8, 7, 0, 0, 0, 0, 3, 1},
			{0, 0, 3, 0, 1, 0, 0, 8, 0},
			{9, 0, 0, 8, 6, 3, 0, 0, 5},
			{0, 5, 0, 0, 9, 0, 6, 0, 0},
			{1, 3, 0, 0, 0, 0, 2, 5, 0},
			{0, 0, 0, 0, 0, 0, 0, 7, 4},
			{0, 0, 5, 2, 0, 6, 3, 0, 0}
		};
		sudoko(array);
		print(array);
	}

	public static boolean sudoko(int[][] array) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (array[i][j] == 0) {
					for (int k = 1; k <= 9; k++) {
						if (isValid(array, i, j, k)) {
							array[i][j] = k;
							if (sudoko(array)) return true;
							else array[i][j] = 0;
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isValid(int[][] array, int row, int col, int num) {
		for (int i = 0; i < 9; i++) {
			if (array[i][col] == num) return false;
			if (array[row][i] == num) return false;
			if (array[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) return false;
		}
		return true;
	}

	public static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
