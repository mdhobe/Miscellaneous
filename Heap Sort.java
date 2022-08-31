import java.io.*;
import java.util.*;

public class C {
	public void main() {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}

		Scanner scan = new Scanner(System.in);
		int arr[] = {12, 11, 13, 5, 6, 7};
		heap(arr);
		for (int element : arr) {
			System.out.print(element + " ");
		}
	}

	public void heap(int[] arr) {
		buildheap(arr, arr.length);
		for (int i = arr.length - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}

	public void buildheap(int[] arr, int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
	}

	public void heapify(int[] arr, int n, int i) {
		int left = 2 * i + 1, right = 2 * i + 2;
		int largest = i;

		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}
		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			heapify(arr, n, largest);
		}
	}

}
