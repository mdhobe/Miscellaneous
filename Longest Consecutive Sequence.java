// class Solution {
//     public int longestConsecutive(int[] nums) {
//         if (nums.length == 0) return 0;
// 		if (nums.length == 1) return 1;

// 		Arrays.sort(nums);
// 		int ans = 1;
// 		int count = 1;

// 		for (int i = 1; i < nums.length; i++) {
// 			if (nums[i - 1] + 1 == nums[i]) count++;
// 			else if(nums[i-1] != nums[i]) count = 1;
// 			ans = Math.max(ans, count);
// 		}

// 		return ans;
//     }
// }

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
		int[] nums = {100, 200, 1, 3, 2, 4};

		System.out.println(longestConsecutive(nums));
	}

	public int longestConsecutive(int[] nums) {
		int count = 1;
		int ans = 1;

		HashSet<Integer> unique = new HashSet<>();
		for (int num : nums) unique.add(num);

		for (int num : nums) {
			if (!unique.contains(num - 1)) {
				int currentNum = num;
				count = 1;
				while (unique.contains(currentNum + 1)) {
					count++;
					currentNum++;
				}
				ans = Math.max(count, ans);
			}
		}

		return ans;
	}

}
