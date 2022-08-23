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
		int[] nums = { 3 , 1 , 7, 1};

		minElements(nums);
	}

	public void minElements(int[] nums) {
		ArrayList<Integer> ans = new ArrayList<>();
		Arrays.sort(nums);
		int sum = 0, sum1 = 0;;

		for (int num : nums) sum += num;

		for (int i = nums.length - 1; i >= 0; i--) {
			if (sum - nums[i] < sum1 + nums[i]) {
				ans.add(nums[i]);
				break;
			} else {
				sum -= nums[i];
				sum1 += nums[i];
				ans.add(nums[i]);
			}
		}

		System.out.println(ans);
	}

}
