import java.io.*;
import java.util.*;

public class B {
	public static char[] directions = { 'D', 'L', 'R', 'U' };
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] array = new int[n];
		for (int i = 1; i <= n; i++) array[i - 1] = i;
		ArrayList<String> ans = new ArrayList<>();

		permutation(array, 0, n, ans);
		Collections.sort(ans);
		System.out.println(ans.get(k - 1));
	}

	public static void permutation(int[] array, int index, int n, ArrayList<String> ans) {
		if (index == n) {
			ans.add(intToString(array));
			return;
		}

		for (int i = index; i < n; i++) {
			swap(array, index, i);
			permutation(array, index + 1, n, ans);
			swap(array, index, i);
		}

	}

	public static void swap (int[] array, int i, int j) {
		int k = array[i];
		array[i] = array[j];
		array[j] = k;
	}

	public static String intToString(int[] array) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			s.append(array[i] + " ");
		}
		return s.toString();
	}
}
