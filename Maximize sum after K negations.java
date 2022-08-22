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
		int[] nums = { -3, -4 , 0, 1, 2, 4, 5};
		int k = 5;
		Arrays.sort(nums);

		System.out.println(maximizeSum(nums, k));
	}

	public int maximizeSum(int[] nums, int k) {
		if (nums.length == 1) {
			if (k % 2 == 0) return nums[0];
			else return -1 * nums[0];
		}
		int index = 0;

		while ( k > 0) {
			if (nums[index] < 0) {
				nums[index] *= -1;
				k--;
				if (nums[index + 1] <= 0 && nums[index] > nums[index + 1]) index++;
			} else if (nums[index] == 0) {
				k = 0;
			} else {
				nums[index] *= -1;
				k--;
			}
		}

		int ans = 0;
		for (int n : nums) ans += n;

		return ans;
	}
}
