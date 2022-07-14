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
		int m = sc.nextInt();
		int e = sc.nextInt();
		int[] color = {0, 0, 0, 0, 0, 0};
		int[][] array = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {4, 3}, {3, 5}, {4, 6}};
		System.out.println(mcolor(0, array, m, n, color));
	}

	public static boolean mcolor(int index, int[][] array, int c, int n, int[] color) {
		if (index == n) return true;

		for (int i = 1; i <= c; i++) {
			if (isValid(array, index, i, color)) {
				color[index] = i;
				if (mcolor(index + 1, array, c, n, color)) return true;
				color[index] = 0;
			}
		}
		return false;
	}

	public static boolean isValid(int[][] array, int index, int c, int[] color) {
		ArrayList<Integer> adj = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			if (index + 1 == array[i][0]) {
				adj.add(array[i][1]);
			} else if (index + 1 == array[i][1]) {
				adj.add(array[i][0]);
			}
		}
		for (int i = 0; i < adj.size(); i++) {
			if (color[adj.get(i) - 1] == c) {
				return false;
			}
		}
		return true;
	}

}
