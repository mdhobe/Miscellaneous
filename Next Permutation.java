class Solution {
    public void nextPermutation(int[] nums) {
        int index1 = nums.length;

		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i - 1] < nums[i]) {
				index1 = i - 1;
				break;
			}
		}

		if (index1 != nums.length) {
			//Step2 : Find a number from backward such that nums[index1] < nums[i]
			int index2 = nums.length - 1;

			for (int i = nums.length - 1; i >= 0; i--) {
				if (nums[index1] < nums[i]) {
					index2 = i;
					break;
				}
			}

			//Step3 : Swap nums[index1] and nums[index2]

			int temp = nums[index1];
			nums[index1] = nums[index2];
			nums[index2] = temp;

			//Step 4 : Reverse everything after index1+1

			for (int i = 0; i < (nums.length - (index1 + 1)) / 2; i++) {
				temp = nums[i + index1 + 1];
				nums[i + index1 + 1] = nums[nums.length - 1 - i];
				nums[nums.length - 1 - i] = temp;
			}

		} else {
			for (int i = 0; i < nums.length / 2; i++) {
				int temp = nums[i];
				nums[i] = nums[nums.length - 1 - i];
				nums[nums.length - 1 - i] = temp;
			}
		}
    }
}
