class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = nums[0], previ = 0;
        for(int i=1;i<nums.length;i++){
            if(prev != nums[i]){
                nums[++previ] = nums[i];
                prev = nums[i];
            }
        }
        return previ+1;
    }
}
