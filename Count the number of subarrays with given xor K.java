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
		int target = scan.nextInt();
		int[] nums = {5, 6, 7, 8, 9};

		xork(nums, target);
	}

	public void xork(int[] nums, int target) {
		int xor = 0, count = 0;
		HashMap<Integer, Integer> xorcheck = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			xor ^= nums[i];
			if (xor == target) count++;
			if (xorcheck.containsKey(nums[i])) {
				count++;
			} else {
				xorcheck.put(xor, i);
			}
		}

		System.out.println(count);
	}

	public void print(int[] nums, int start, int end) {
		for (int i = start; i <= end; i++) System.out.print(nums[i] + " ");
		System.out.println();
	}

}
