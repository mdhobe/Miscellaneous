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
		int[] nums = {3, 3, 7, 7, 10, 11, 11};
		singleNonDuplicate(nums);
	}

	public int singleNonDuplicate(int[] nums) {
		int low = 0;
		int high = nums.length - 2;

		while (low <= high) {
			int mid = (high + low) / 2;
			if (mid % 2 == 0) {
				if (nums[mid] != nums[mid + 1]) high = mid - 1;
				else low = mid + 1;
			} else {
				if (nums[mid] == nums[mid + 1]) high = mid - 1;
				else low = mid + 1;
			}
		}
		System.out.println(nums[low]);
		return nums[low];
	}


}
