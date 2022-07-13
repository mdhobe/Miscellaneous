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
		int[] array = new int[n];
		for (int i = 0; i < n; i++) array[i] = sc.nextInt();
		permutations(0, array, n);
	}

	public static void permutations(int index, int[] array, int n) {
		if (index == n) {
			print(array);
			return;
		}
		for (int i = index; i < n; i++) {
			swap(array, index, i);
			permutations(index + 1, array , n);
			swap(array, index, i);
		}
	}

	public static int[] swap(int[] array, int i, int j) {
		int swap = array[i];
		array[i] = array[j];
		array[j] = swap;
		return array;
	}

	public static void print(int[] array) {
		for (int a : array) System.out.print(a + " ");
		System.out.println();
	}

}
