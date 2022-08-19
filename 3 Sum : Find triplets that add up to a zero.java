// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         Arrays.sort(nums);

//         HashSet<List<Integer>> ans = new HashSet<>();
//         HashMap<Integer, Integer> unique = new HashMap<>();
        
//         for(int i=0;i<nums.length;i++){
//             if(unique.containsKey(nums[i])){
//                 int count = unique.get(nums[i]);
//                 unique.put(nums[i], ++count);
//             } else {
//                 unique.put(nums[i], 1);
//             }
//         }
        
//         for(int i=0;i<nums.length;i++){
//             int counti = unique.get(nums[i]);
//             unique.put(nums[i], --counti);
//             for(int j=i+1;j<nums.length;j++){
//                 int countj = unique.get(nums[j]);
//                 unique.put(nums[j], --countj);
                
//                 if(unique.containsKey(-1*(nums[i]+nums[j])) && unique.get(-1*(nums[i]+nums[j])) > 0){
//                     ArrayList<Integer> a = new ArrayList<>();
//                     a.add(nums[i]);
//                     a.add(nums[j]);
//                     a.add(-1*(nums[i]+nums[j]));
//                     Collections.sort(a);
//                     ans.add(new ArrayList(a));
//                 }
                
//                 unique.put(nums[j], ++countj);
//             }
//         }
        
//         List<List<Integer>> list =new ArrayList<>();
//         list.addAll(ans);
        
//         return list;
//     }
// }

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i<nums.length-2;i++){
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
            int low = i + 1, high = nums.length - 1;
            while(low < high){
                if(nums[i] + nums[low] + nums[high] == 0){
                    List<Integer> a = new ArrayList<>();
                    a.add(nums[i]);
                    a.add(nums[low]);
                    a.add(nums[high]);
                    Collections.sort(a);
                    ans.add(new ArrayList(a));
                    while(low < high && nums[low] == nums[low+1]) low++;
                    while(low < high && nums[high] == nums[high-1]) high--;
                    low++;
                    high--;
                } else if(nums[i] + nums[low] + nums[high] > 0){
                    high--;
                } else if(nums[i] + nums[low] + nums[high] < 0){
                    low++;
                }
            }}
        }
        
        return ans;
    }
}
