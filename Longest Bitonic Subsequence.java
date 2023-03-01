class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        int[] dpl = new int[n];

        for(int i=0;i<n;i++){
            dpl[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j] && dpl[i] < dpl[j]+1){
                    dpl[i] = dpl[j]+1;
                }
            }
        }

        int[] dps = new int[n];

        for(int i=n-1;i>=0;i--){
            dps[i] = 1;
            for(int j=n-1;j>i;j--){
                if(nums[i] > nums[j] && dps[i] < dps[j]+1){
                    dps[i] = dps[j]+1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++){
            if (dpl[i] > 1 && dps[i] > 1)
                max = Math.max(dpl[i] + dps[i] - 1, max);
        }
        return n - max;
    }
}
