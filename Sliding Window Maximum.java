// Brut Force
// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         if (k == 1) return nums;
// 		int n = nums.length;
// 		int[] ans = new int[n - k + 1];
// 		for (int i = 0; i < n - k + 1; i++) {
// 			ans[i] = max(i, i + k, nums);
// 		}
// 		return ans;
//     }
    
//     public int max(int start, int end, int[] nums) {
// 		int max = nums[start];
// 		for (int i = start; i < end; i++) {
// 			max = Math.max(nums[i], max);
// 		}
// 		return max;
//     } 
    
// }

//Optimum
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> q = new ArrayDeque<>();
        int ri = 0;
        
        for(int i=0;i<n;i++){
            if(!q.isEmpty() && q.peek() == i-k) q.poll();
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) q.pollLast();
            q.offer(i);
            if(i >= k-1) ans[ri++] = nums[q.peek()];
        }
        return ans;
    }
}
