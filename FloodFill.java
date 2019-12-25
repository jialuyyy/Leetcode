//[[1,1,1],[1,1,0],[1,0,1]]
//sr = 1, sc = 1, newColor = 2
/*
   111
   110
   101
*/


/*[2,2,2]
  [2,2,0]
  [2,0,1]
*/
class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0)
            return new int[][]{};
        
        int color = image[sr][sc];
        
        if (image[sr][sc] != newColor)
            helper(image, sr, sc, color, newColor);
        return image;
    }
    
    private void helper(int[][] image, int sr, int sc, int color, int newColor) {
        if (image[sr][sc] == color) {
            image[sr][sc] = newColor;
            if (sr >= 1)
                helper(image, sr - 1, sc, color, newColor);
            if (sc >= 1)
                helper(image, sr, sc - 1, color, newColor);
            if (sr < image.length - 1)
                helper(image, sr + 1, sc, color, newColor);
            if (sc < image[0].length - 1)
                helper(image, sr, sc + 1, color, newColor);
        }
    }
}
