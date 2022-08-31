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
		int arr[] = {1, 2, 8, 4, 9};
		Arrays.sort(arr);
		int k = 4, n = 6;
		System.out.println(isCompatible(arr, k, n));
	}

// 	public int isCompatible(int[] stalls, int cows, int n) {
// 		int min = 1;

// 		for (int i = 1; i <= stalls[stalls.length - 1]; i++) {
// 			int cow = 1;
// 			int prevcow = stalls[0];
// 			for (int j = 1; j < stalls.length; j++) {
// 				if (stalls[j] - prevcow >= i) {
// 					cow++;
// 					prevcow = stalls[j];
// 				}
// 			}
// 			if (cow >= cows) min = i;
// 		}

// 		return min;
// 	}
  
  public int isCompatible(int[] stalls, int cows, int n) {
		int min = 1;

		int low = 1, high = stalls[n - 1];

		while (low <= high) {
			int mid = (low + high) >> 1;
			int cow = 1;
			int prevcow = stalls[0];
			for (int j = 1; j < stalls.length; j++) {
				if (stalls[j] - prevcow >= mid) {
					cow++;
					prevcow = stalls[j];
				}
			}
			if (cow >= cows) {
				min = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return min;
	}

}
