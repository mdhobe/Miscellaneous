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
		int[][] array = new int[n][n];
		for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) array[i][j] = 0;
		ArrayList<Integer> rows = new ArrayList<>();
		permutations(0, array, n, rows);
	}

	public static void permutations(int index, int[][] array, int n, ArrayList<Integer> rows) {
		if (index == n) {
			print(array);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!rows.contains(i)) {
				if (index == 0) {
					array[index][i] = 1;
					rows.add(i);
					permutations(index + 1, array, n, rows);
					array[index][i] = 0;
					rows.remove(rows.size() - 1);
				} else {
					if (i == 0 && array[index - 1][i + 1] == 0) {
						array[index][i] = 1;
						rows.add(i);
						permutations(index + 1, array, n, rows);
						array[index][i] = 0;
						rows.remove(rows.size() - 1);
					} else if (i == n - 1) {
						if (array[index - 1][i - 1] == 0) {
							array[index][i] = 1;
							rows.add(i);
							permutations(index + 1, array, n, rows);
							array[index][i] = 0;
							rows.remove(rows.size() - 1);
						}
					} else if (array[index - 1][i + 1] == 0 && array[index - 1][i - 1] == 0) {
						array[index][i] = 1;
						rows.add(i);
						permutations(index + 1, array, n, rows);
						array[index][i] = 0;
						rows.remove(rows.size() - 1);
					} else {
						continue;
					}
				}
			}
		}

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
