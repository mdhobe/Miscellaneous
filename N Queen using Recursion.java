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
		int[] rdiagonal = new int[2 * n - 1];
		int[] ldiagonal = new int[2 * n - 1];
		ArrayList<Integer> rows = new ArrayList<>();
		permutations(0, array, n, rows, rdiagonal, ldiagonal);
	}

	public static void permutations(int index, int[][] array, int n, ArrayList<Integer> rows, int[] rdiagonal, int[] ldiagonal) {
		if (index == n) {
			print(array);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!rows.contains(i) && rdiagonal[index + i] == 0 && ldiagonal[n - 1 + index - i] == 0) {
				array[index][i] = 1;
				rows.add(i);
				rdiagonal[index + i] = 1;
				ldiagonal[n - 1 + index - i] = 1;
				permutations(index + 1, array, n, rows, rdiagonal, ldiagonal);
				array[index][i] = 0;
				rows.remove(rows.size() - 1);
				rdiagonal[index + i] = 0;
				ldiagonal[n - 1 + index - i] = 0;
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
