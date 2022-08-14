class Solution {
//     public int[] twoSum(int[] num, int target) {
// 		int[] nums = new int[num.length];
// 		for (int i = 0; i < num.length; i++) nums[i] = num[i];
// 		Arrays.sort(nums);
// 		int left = 0, right = nums.length - 1;
// 		int leftnum = nums[left], rightnum = nums[right];
// 		int sum = leftnum + rightnum;

// 		while (sum != target) {
// 			if (sum > target) {
// 				right--;
// 			} else if (sum < target) {
// 				left++;
// 			}
// 			leftnum = nums[left];
// 			rightnum = nums[right];
// 			sum = leftnum + rightnum;
// 		}

// 		int ans1 = find(num, leftnum);
// 		int ans2 = find(num, rightnum);

// 		if(ans1 == ans2) ans2 = lastFind(num,rightnum);

// 		int[] ans = new int[2];
// 		ans[0] = ans1;
// 		ans[1] = ans2;
// 		return ans;
// 	}

// 	public int find(int[] nums, int num) {
// 		for (int i = 0; i < nums.length; i++) if (nums[i] == num) return i;
// 		return 0;
// 	}
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
		int[] nums = {2, 7, 11, 15};

		print(twoSum(nums, target));
	}

	public int[] twoSum(int[] num, int target) {
		int[] ans = new int[2];
		HashMap<Integer, Integer> myhash = new HashMap<>();

		for (int i = 0; i < num.length; i++) {
			if (myhash.containsKey(num[i])) {
				ans[0] = myhash.get(num[i]);
				ans[1] = i;
				break;
			} else {
				myhash.put(target - num[i], i);
			}
		}                                               

		return ans;
	}

}
