class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = (low+high) >> 1;
            if(mid == 0 && nums[mid] > nums[mid+1]) return mid;
            else if(mid == nums.length-1 && nums[mid-1] < nums[mid]) return mid;
            else if(mid != 0 && mid != nums.length-1 && nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]){
                return mid;
            } else if(mid != 0 && nums[mid-1] > nums[mid]) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return 0;
    }
}
