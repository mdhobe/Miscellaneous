class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        int [][] t=new int[m][n];
        for(int [] a:t) Arrays.fill(a,200000);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0) t[i][j]=0;
                else{
                    if(i>0 && j==0) t[i][j]=Math.min(t[i-1][j]+1,t[i][j]);
                    else if(j>0 && i==0) t[i][j]=Math.min(t[i][j-1]+1,t[i][j]);
                    else if(i>0 && j>0) t[i][j]=Math.min(Math.min(t[i-1][j]+1,t[i][j-1]+1),t[i][j]);
                }
            }
        }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(mat[i][j]==0) t[i][j]=0;
                else{
                    if(i<m-1 && j==n-1) t[i][j]=Math.min(t[i+1][j]+1,t[i][j]);
                    else if(j<n-1 && i==m-1) t[i][j]=Math.min(t[i][j+1]+1,t[i][j]);
                    else if(i<m-1 && j<n-1) t[i][j]=Math.min(Math.min(t[i+1][j]+1,t[i][j+1]+1),t[i][j]);
                }
            }
        }
        return t;
    }
}
