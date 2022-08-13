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
		int[] array = {5, 3, 2, 4, 1};
		int[] temp = new int[array.length];
		System.out.println(mergeSort(array, temp, 0, array.length - 1));
		print(array);
	}

	public int mergeSort(int[] array, int[] temp, int left, int right) {
		int mid = 0, count = 0;
		if (right > left) {
			mid = (left + right) / 2;
			count += mergeSort(array, temp, left, mid);
			count += mergeSort(array, temp, mid + 1, right);

			count += merge(array, temp, left, mid + 1, right);
		}
		return count;
	}

	public int merge(int[] array, int[] temp, int left, int mid, int right) {
		int i = left, j = mid, k = left;
		int invcount = 0;

		while ((i <= mid - 1) && (j <= right)) {
			if (array[i] <= array[j]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];

				invcount += (mid - i);
			}
		}

		while (i <= mid - 1) temp[k++] = array[i++];
		while (j <= right) temp[k++] = array[j++];

		for (i = left; i <= right; i++) array[i] = temp[i];

		return invcount;
	}

	public void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
