class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

		if (num == null || num.length == 0) return res;
		int n = num.length;
		Arrays.sort(num);
		for (int i = 0; i < n; i++) {
			long target_3 = target - num[i];
			for (int j = i + 1; j < n; j++) {
				long target_2 = target_3 - num[j];
				int front = j + 1;
				int back = n - 1;
				while (front < back) {
					long two_sum = num[front] + num[back];
					if (two_sum < target_2) front++;
					else if (two_sum > target_2) back--;
					else {
						List<Integer> quad = new ArrayList<>();
						quad.add(num[i]);
						quad.add(num[j]);
						quad.add(num[front]);
						quad.add(num[back]);
						res.add(quad);
						while (front < back && num[front] == quad.get(2)) ++front;
						while (front < back && num[back] == quad.get(3)) --back;
					}
				}
				while (j + 1 < n && num[j + 1] == num[j]) ++j;
			}
			while (i + 1 < n && num[i + 1] == num[i]) ++i;
		}
		return res;
	}
  
  // public void fourSum(int[] nums, int target) {
	// 	List<List<Integer>> ans = new ArrayList<>();
	// 	//if (nums.length == 0) return ans;

	// 	Arrays.sort(nums);
	// 	print(nums);

	// 	for (int i = 0; i < nums.length; i++) {
	// 		for (int j = i + 1; j < nums.length; j++) {
	// 			List<Integer> item = new ArrayList<>();

	// 			int target1 = target - nums[i] - nums[j];
	// 			int left = j + 1, right = nums.length - 1;

	// 			while (left < right) {
	// 				int sum = nums[left] + nums[right];
	// 				if (sum > target1) {
	// 					right--;
	// 				} else if (sum < target1) {
	// 					left++;
	// 				} else {
	// 					item.add(nums[i]);
	// 					item.add(nums[j]);
	// 					item.add(nums[left]);
	// 					item.add(nums[right]);
	// 					ans.add(new ArrayList(item));

	// 					while (left < right && nums[left] == item.get(2)) ++left;
	// 					while (left < right && nums[right] == item.get(3)) --right;
	// 				}
	// 				System.out.println(left + " " + right);
	// 			}
	// 			while (j + 1 < nums.length && nums[j + 1] == nums[j]) ++j;
	// 		}
	// 		while (i + 1 < nums.length && nums[i + 1] == nums[i]) ++i;
	// 	}

	// 	System.out.println(ans);
	// }
}
