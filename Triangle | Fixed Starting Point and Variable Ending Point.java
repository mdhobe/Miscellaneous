// Memoization
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) dp[i][j] = Integer.MAX_VALUE-1;

        return minimumTotal(0,0,n,triangle,dp);
    }

    public int minimumTotal(int row, int col,int size, List<List<Integer>> triangle,int[][] dp){
        if(row == size-1 && 0 <= col && col < size) return triangle.get(row).get(col);
        if(row >= size || col < 0 || col >= size) return Integer.MAX_VALUE;
        if(dp[row][col] != Integer.MAX_VALUE-1) return dp[row][col];

        int left = triangle.get(row).get(col) + minimumTotal(row+1, col, size, triangle, dp);
        int right = triangle.get(row).get(col) + minimumTotal(row+1, col+1, size, triangle, dp);

        return dp[row][col] = Math.min(left, right);
    }
}

//Tabulation
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        dp[0][0] = triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                int left = Integer.MAX_VALUE;
                if(j > 0) left = triangle.get(i).get(j) + dp[i-1][j-1];

                int right = Integer.MAX_VALUE;
                if(j != i) right = triangle.get(i).get(j) + dp[i-1][j];

                dp[i][j] = Math.min(left, right);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) min = Math.min(min, dp[n-1][i]);

        return min;
    }
}

//Space Optimization
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);

        for(int i=1;i<n;i++){
            int[] temp = new int[n];
            for(int j=0;j<=i;j++){
                int left = Integer.MAX_VALUE;
                if(j > 0) left = triangle.get(i).get(j) + dp[j-1];

                int right = Integer.MAX_VALUE;
                if(j != i) right = triangle.get(i).get(j) + dp[j];

                temp[j] = Math.min(left, right);
            }
            for(int j=0;j<n;j++) dp[j] = temp[j];
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) min = Math.min(min,dp[i]);

        return min;
    }
}
