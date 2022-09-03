class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length-1;
        int column = matrix[0].length-1;
        int low = matrix[0][0];
        int high = matrix[row][column];
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            
            int count = CountLessThanEqualMid(mid,matrix);
            if(count<k)
                low = mid+1;
            else
                high = mid-1;
        }
        return low;
    }
    
    public int CountLessThanEqualMid(int mid, int[][] matrix)
    {
        int row = matrix.length;
        int column = matrix[0].length;
        int ans = 0;
        for(int i=0;i<row;i++)
        {
            int low = 0;
            int high = column-1;
            while(low<=high)
            {
                int m = low + (high - low)/2;
                if(matrix[i][m]<=mid)
                    low = m+1;
                else
                    high = m-1;
            }
            ans +=low;
        }
        return ans;
    }
}
