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
		int[] arr = {4, 3, 6, 2, 1, 1};
		findMissingAndDuplicateXOR(arr);
	}

	public void findMissingAndDuplicate(int[] arr) {
		long n = arr.length;
		long sum = (n * (n + 1)) / 2;
		long sum2 = (n * (n + 1) * (2 * n + 1)) / 6;

		long m = 0, d = 0;

		for (long item : arr) {
			sum -= item;
			sum2 -= item * item;
		}

		m = (sum + sum2 / sum) / 2;
		d = sum2 / sum - m;

		System.out.println(m);
		System.out.println(d);

	}

	public void findMissingAndDuplicateXOR(int[] arr) {
		int xor = 0;
		for (int num : arr) xor ^= num;
		for (int i = 1; i < arr.length + 1; i++) xor ^= i;

		//m^d = xor

		ArrayList<Integer> x1 = new ArrayList<>();
		ArrayList<Integer> x0 = new ArrayList<>();
		int bit = Integer.toBinaryString(xor).length() - 1;

		for (int num : arr) {
			String binary = Integer.toBinaryString(num);
			if (binary.length() > bit) {
				x1.add(num);
			} else {
				x0.add(num);
			}
		}

		for (int i = 1; i < arr.length + 1; i++) {
			String binary = Integer.toBinaryString(i);
			if (binary.length() > bit) {
				x1.add(i);
			} else {
				x0.add(i);
			}
		}

		int m = 0;
		for (int i = 0; i < x1.size(); i++) m ^= x1.get(i);

		int d = 0;
		for (int i = 0; i < x0.size(); i++) d ^= x0.get(i);

		System.out.println(m);
		System.out.println(d);
	}

}
