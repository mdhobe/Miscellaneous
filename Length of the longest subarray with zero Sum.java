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
		int[] nums = {6, -2, 2, -8, 1, 7, 4, -10};

		longestArray(nums);
	}

	public void longestArray(int[] nums) {
		int sum = 0, max = 0;;
		HashMap<Integer, Integer> sumcheck = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum == 0) max = i + 1;
			else {
				if (sumcheck.containsKey(sum)) {
					max = Math.max(max, i - sumcheck.get(sum));
				} else {
					sumcheck.put(sum, i);
				}
			}
		}

		System.out.println(max);
	}

	public void print(int[] nums, int start, int end) {
		for (int i = start; i <= end; i++) System.out.print(nums[i] + " ");
		System.out.println();
	}

}
