// Memoization
class Solution {
    public int maxCoins(int[] nums) {
        int size = nums.length;
        int[][] dp = new int[size+2][size+2];
        for(int i=0;i<size+2;i++) for(int j=0;j<size+2;j++) dp[i][j] = -1;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        for(int n : nums) arr.add(n);
        arr.add(1);

        return maxCoins(1, nums.length, arr, dp);
    }
    public int maxCoins(int i, int j, ArrayList<Integer> nums, int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int max = (int) -1e9;
        for(int k=i;k<=j;k++){
            int coins = nums.get(i-1) * nums.get(k) * nums.get(j+1) +
                maxCoins(i, k-1, nums, dp) +
                maxCoins(k+1, j, nums, dp);
            max = Math.max(max, coins);
        }

        return dp[i][j] = max;
    }
}

// Tabulation
class Solution {
    public int maxCoins(int[] nums) {
        int size = nums.length;
        int[][] dp = new int[size+2][size+2];
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        for(int n : nums) arr.add(n);
        arr.add(1);

        for(int i=size;i>0;i--){
            for(int j=1;j<=size;j++){
                if(i > j) continue;
                int max = (int) -1e9;
                for(int k=i;k<=j;k++){
                    int coins = arr.get(i-1) * arr.get(k) * arr.get(j+1) +
                        dp[i][k-1] +
                        dp[k+1][j];
                    max = Math.max(max, coins);
                }
                dp[i][j] = max;
            }
        }

        return dp[1][size];
    }
}
