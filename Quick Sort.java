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
		int[] array = {1, 5, 3, 2, 8, 7, 6, 4};
		int n = array.length;
		quickSort(array, 0, n - 1);
		print(array);
	}

	public void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int p = partition(array, low, high);
			quickSort(array, low, p - 1);
			quickSort(array, p + 1, high);
		}
	}

	public int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int startindex = low;

		for (int i = low; i < high; ++i) {
			if (array[i] < pivot) {
				int temp = array[i];
				array[i] = array[startindex];
				array[startindex] = temp;
				startindex++;
			}
		}

		int temp = array[startindex];
		array[startindex] = array[high];
		array[high] = temp;

		return startindex;
	}

	public void print(int[] array) {
		for (int num : array) System.out.print(num + " ");
		System.out.println();
	}

}
