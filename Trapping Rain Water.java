// class Solution {
//     public int trap(int[] height) {
//         int ans = 0;
//         if(height.length == 1 || height.length == 2) return ans;
        
//         int leftMax = 0, rightMax = 0;
//         for(int i=1;i<height.length-1;i++){
//             if(Math.min(leftMax(i,height),rightMax(i,height)) > height[i]){
//                 ans += Math.min(leftMax(i,height),rightMax(i,height)) - height[i];
//             }
//         }
        
//         return ans;
//     }
//     public int leftMax(int index, int[] heights){
//         int max = 0;
//         for(int i=0;i<index;i++){
//             max = Math.max(heights[i],max);
//         }
//         return max;
//     }
//     public int rightMax(int index, int[] heights){
//         int max = 0;
//         for(int i=index+1;i<heights.length;i++){
//             max = Math.max(heights[i],max);
//         }
//         return max;
//     }
// }

// class Solution {
//     public int trap(int[] height) {
//         int ans = 0, len = height.length;
//         if(len == 1 || len == 2) return ans;
        
//         int[] leftMax = new int[len];
//         leftMax[0] = height[0];
//         int[] rightMax = new int[len];
//         rightMax[len-1] = height[len-1];
        
//         for(int i=1;i<len;i++){
//             leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
//             rightMax[len-i-1] = Math.max(rightMax[len-i], height[len-i]);
//         }

        
//         for(int i=1;i<len-1;i++){
//             if(Math.min(leftMax[i],rightMax[i]) > height[i]){
//                 ans += Math.min(leftMax[i],rightMax[i]) - height[i];
//             }
//         }
        
//         return ans;
//     }
// }

class Solution {
    public int trap(int[] height) {
        int ans = 0, len = height.length;
        if(len == 1 || len == 2) return ans;
        
        int maxLeft = 0, maxRight = 0, l = 0, r = len-1;
        
        while(l <= r){
            if(height[l] <= height[r]){
                if(height[l] > maxLeft){
                    maxLeft = height[l];
                } else {
                    ans += maxLeft - height[l];
                }
                l++;
            } else if(height[l] >= height[r]) {
                if(height[r] > maxRight){
                    maxRight = height[r];
                } else {
                    ans += maxRight - height[r];
                }
                r--;
            }
        }
        
        return ans;
    }
}
