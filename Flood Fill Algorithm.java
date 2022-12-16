class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length, m = image[0].length;
        int[][] modifiedImage = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                modifiedImage[i][j] = image[i][j];
            }
        }
        dfs(modifiedImage, sr,sc,image,color);
        return modifiedImage;
    }
    public void dfs(int[][] modifiedImage, int x, int y, int[][] image, int color){
        modifiedImage[x][y] = color;

        if (y < modifiedImage[0].length - 1 && image[x][y + 1] == image[x][y] && modifiedImage[x][y + 1] != modifiedImage[x][y]) {
 			modifiedImage[x][y + 1] = color;
 			dfs(modifiedImage, x, y + 1, image, color);
 		}
 		if (y > 0 && image[x][y - 1] == image[x][y] && modifiedImage[x][y - 1] != modifiedImage[x][y]) {
 			modifiedImage[x][y - 1] = color;
 			dfs(modifiedImage, x, y - 1, image, color);
 		}
 		if (x < modifiedImage.length - 1 && image[x + 1][y] == image[x][y] && modifiedImage[x+1][y] != modifiedImage[x][y]) {
 			modifiedImage[x + 1][y] = color;
 			dfs(modifiedImage, x+1, y, image, color);
 		}
 		if (x > 0 && image[x - 1][y] == image[x][y] && modifiedImage[x-1][y] != modifiedImage[x][y]) {
 			modifiedImage[x - 1][y] = color;
 			dfs(modifiedImage, x-1, y, image, color);
 		}
    }
}
