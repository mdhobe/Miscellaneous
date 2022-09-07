class Solution {
    
    int height;
    int width;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        height = image.length;
        width = image[0].length;
        
        int originColor = image[sr][sc];
        fill(image, sr, sc, originColor, color);
        
        return image;
        
    }
    
    public void fill(int[][] image, int sr, int sc, int originColor, int color) {
        if (sr < 0 || sc <0 || sr > height - 1 || sc > width - 1) return;
        
        if (image[sr][sc] != originColor || image[sr][sc] == color) return;
        
        image[sr][sc] = color;
        
        fill(image, sr + 1, sc, originColor, color);
        fill(image, sr - 1, sc, originColor, color);
        fill(image, sr, sc + 1, originColor, color);
        fill(image, sr, sc - 1, originColor, color);
    }
}
