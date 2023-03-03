// Memoization
class Solution {
    public int minCost(int n, int[] cuts) {
        int size = cuts.length;
        Arrays.sort(cuts);
        int[][] dp = new int[size+2][size+2];
        for(int i=0;i<size+2;i++) for(int j=0;j<size+2;j++) dp[i][j] = -1;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(0);
        for(int i=0;i<cuts.length;i++) arr.add(cuts[i]);
        arr.add(n);

        return minCost(1, size, arr, dp);
    }
    public int minCost(int i, int j, ArrayList<Integer> cuts, int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min = (int) 1e9;
        for(int k=i;k<=j;k++){
            int cost = cuts.get(j+1) - cuts.get(i-1) + 
                minCost(i, k-1, cuts, dp) + 
                minCost(k+1, j, cuts, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }
}

// Tabulation
// Tabulation
class Solution {
    public int minCost(int n, int[] cuts) {
        int size = cuts.length;
        Arrays.sort(cuts);
        int[][] dp = new int[size+2][size+2];
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(0);
        for(int i=0;i<cuts.length;i++) arr.add(cuts[i]);
        arr.add(n);

        for(int i=size;i>0;i--){
            for(int j=1;j<=size;j++){
                if(i > j) continue;
                int min = (int) 1e9;
                for(int k=i;k<=j;k++){
                    int cost = arr.get(j+1) - arr.get(i-1) + 
                        dp[i][k-1] + 
                        dp[k+1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }

        return dp[1][size];
    }
}
