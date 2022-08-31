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
		int arr1[] = {1, 10, 10, 25, 40, 54, 79};
		int arr2[] = {15, 24, 27, 32, 33, 39, 48, 68, 82, 88, 90};
		int m = arr1.length;
		int n = arr2.length;
		int k = 15;
		System.out.println(kthelement(arr1, arr2, m, n, k));
	}

	public int kthelement(int[] arr1, int[] arr2, int m, int n, int k) {
		if (m > n)return kthelement(arr2, arr1, n, m, k);

		int low = Math.max(0, k - m), high = Math.min(k, n);
		while (low <= high) {
			int cut1 = (low + high) >> 1;
			int cut2 = k - cut1;
			int l1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1 - 1];
			int l2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];
			int r1 = (cut1 == 0) ? Integer.MAX_VALUE : arr1[cut1];
			int r2 = (cut2 == 0) ? Integer.MAX_VALUE : arr2[cut2];

			if (l1 <= r2 && l2 <= r1) {
				return Math.max(l1, l2);
			} else if (l1 > l2) {
				high = cut1 - 1;
			} else {
				low = cut1 + 1;
			}
		}
		return -1;
	}

}
