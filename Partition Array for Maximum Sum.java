// Memoization
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++) dp[i] = -1;
        return maxSumAfterPartitioning(0, arr, n, k, dp);
    }
    public int maxSumAfterPartitioning(int i, int[] arr, int n, int k, int[] dp) {
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];
        int count = 0;
        for(int j=i;j<Math.min(i+k, n);j++){
            if(j < i + k){
                int sum = (j-i+1) * max(i, j, arr) + maxSumAfterPartitioning(j+1, arr, n, k, dp);
                count = Math.max(sum, count);
            }
        }
        return dp[i] = count;
    }
    public int max(int i, int j, int[] arr){
        int maxn = 0;
        for(int c=i;c<=j;c++) maxn = Math.max(maxn, arr[c]);
        return maxn;
    }
}

// Tabulation
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];

        for(int i=n-1;i>=0;i--){
            int count = 0;
            for(int j=i;j<Math.min(i+k, n);j++){
                if(j < i + k){
                    int sum = (j-i+1) * max(i, j, arr) + dp[j+1];
                    count = Math.max(sum, count);
                }
            }
            dp[i] = count;
        }

        return dp[0];
    }
    public int max(int i, int j, int[] arr){
        int maxn = 0;
        for(int c=i;c<=j;c++) maxn = Math.max(maxn, arr[c]);
        return maxn;
    }
}
