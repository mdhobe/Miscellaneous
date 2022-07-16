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
		int n = scan.nextInt();
		int[] array = {4, 2, 7, 5, 1, 6, 3, 8};
		print(mergeSort(array));
	}

	public int[] mergeSort(int[] array) {
		if (array.length <= 1) {
			return array;
		}
		int mid = array.length / 2;
		int[] left = mergeSort(Arrays.copyOfRange(array, 0, mid));
		int[] right = mergeSort(Arrays.copyOfRange(array, mid, array.length));
		return merge(left, right);
	}

	public int[] merge(int[] left, int[] right) {
		int[] slist = new int[left.length + right.length];
		int lindex = 0;
		int rindex = 0;
		int sindex = 0;
		while (lindex < left.length && rindex < right.length) {
			if (left[lindex] < right[rindex]) {
				slist[sindex] = left[lindex];
				sindex++;
				lindex++;
			} else {
				slist[sindex] = right[rindex];
				sindex++;
				rindex++;
			}
		}
		while (lindex < left.length) {
			slist[sindex] = left[lindex];
			sindex++;
			lindex++;
		}
		while (rindex < right.length) {
			slist[sindex] = right[rindex];
			sindex++;
			rindex++;
		}
		return slist;
	}

	public void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
