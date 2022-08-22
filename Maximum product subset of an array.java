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
		int[] nums = { 4, 3, 0, -2, -1, -1};

		maxProductSubset(nums);
	}

	public void maxProductSubset(int[] nums) {
		int ans = 1, count = 0, n = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				ans *= nums[i];
				if (nums[i] < 0) n++;
			} else count++;
		}

		if (n == 1 && count > 0) ans = 0;
		else if (ans < 0 && nums[nums.length - 1] != 0) ans /= nums[nums.length - 1];

		System.out.println(ans);
	}
}
