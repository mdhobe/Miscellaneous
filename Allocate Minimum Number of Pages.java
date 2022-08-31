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
		int arr[] = {12, 34, 67, 90};
		int k = 2;
		ArrayList<Integer> array = new ArrayList<>();
		for (int a : arr)array.add(a);
		System.out.println(books(array, k));
	}

	public int books(ArrayList<Integer> A, int B) {
		if (B > A.size()) return -1;
		int low = A.get(0), high = 0;
		for (int i = 0; i < A.size(); i++) {
			high += A.get(i);
			low = Math.min(low, A.get(i));
		}
		int res = -1;
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (isPossible(A, B, mid)) {
				res = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	public boolean isPossible(ArrayList<Integer> A, int students, int pages) {
		int count = 0, sum = 0;
		for (int i = 0; i < A.size(); i++) {
			if (sum + A.get(i) > pages) {
				count += 1;
				sum = A.get(i);
				if (sum > pages) return false;
			} else {
				sum += A.get(i);
			}
		}
		if (count < students) return true;
		return false;
	}

}
