class Solution {
    public int majorityElement(int[] nums) {
        int element = nums[0], count = 1;

		for (int i = 1; i < nums.length; i++) {
			if (element == nums[i]) count++;
			else if (element != nums[i]) {
				count--;
				if (count == 0)
				{
					element = nums[i];
					count++;
				}
			}
		}

		System.out.println(element);
		return element;
    }
}
