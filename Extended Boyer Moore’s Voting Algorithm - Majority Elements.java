class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = -1, num2 = -1, count1 = 0, count2 = 0;

		for (int item : nums) {
			if (item == num1) count1++;
			else if (item == num2) count2++;
			else if (count1 == 0) {
				num1 = item;
				count1 = 1;
			} else if (count2 == 0) {
				num2 = item;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}

		List<Integer> ans = new ArrayList<>();
		count1 = 0;
		count2 = 0;
		for (int num : nums) {
			if (num == num1) count1++;
			if (num == num2) count2++;
		}

		if (num1 == num2) {
			if (count1 > nums.length / 3) ans.add(num1);
		} else {
			if (count1 > nums.length / 3) ans.add(num1);
			if (count2 > nums.length / 3) ans.add(num2);
		}
        
        return ans;
    }
}
