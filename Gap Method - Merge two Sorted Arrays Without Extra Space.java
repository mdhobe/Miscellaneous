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
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr1 = {1, 4, 7, 8, 10, 15}, arr2 = {2, 3, 9, 12};
		mergeTwoArray(arr1, arr2);
	}

	public void mergeTwoArray(int[] arr1, int[] arr2) {
		print(arr1);
		print(arr2);

		int gap = (int) Math.ceil((arr1.length + arr2.length) / 2);

		while (gap > 0) {
			for (int  i = 0; i < arr1.length + arr2.length - gap; i++) {
				if (i + gap < arr1.length && arr1[i] > arr1[i + gap]) {
					int temp = arr1[i];
					arr1[i] = arr1[i + gap];
					arr1[i + gap] = temp;
				} else if (i < arr1.length && i + gap >= arr1.length && arr1[i] > arr2[i + gap - arr1.length]) {
					int temp = arr1[i];
					arr1[i] = arr2[i + gap - arr1.length];
					arr2[i + gap - arr1.length] = temp;
				} else if (i >= arr1.length && arr2[i - arr1.length] > arr2[i + gap - arr1.length]) {
					int temp = arr2[i - arr1.length];
					arr2[i - arr1.length] = arr2[i + gap - arr1.length];
					arr2[i + gap - arr1.length] = temp;
				}
			}
			if (gap / 2 == 0) gap = 0;
			else gap = (int) Math.ceil(gap / 2);
		}

		print(arr1);
		print(arr2);
	}

	public void print(int[] array) {
		for (int item : array) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

}
