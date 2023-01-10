class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here
        int rows = matrix.length, cols = matrix[0].length;
        //replace -1 with MAX
        for(int i=0;i<rows;i++) for(int j=0;j<cols;j++) if(matrix[i][j] == -1) matrix[i][j] = Integer.MAX_VALUE;
        for(int k=0;k<cols;k++){
            // vis via k
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE){
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);   
                    }
                }
            }   
        }
        //replace MAX with -1
        for(int i=0;i<rows;i++) for(int j=0;j<cols;j++) if(matrix[i][j] == Integer.MAX_VALUE) matrix[i][j] = -1;
    }
}
