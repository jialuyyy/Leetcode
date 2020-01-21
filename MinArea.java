//brute force 
//time complexity : O(mn)
//iterate over all the point on the image and get the left, right, top, bottom boundarys and get the area
class MinArea {
    public int minArea(char[][] image, int x, int y) {
        int top = x;
        int bottom = x;
        int left = y;
        int right = y;
        
        int rows = image.length;
        int cols = image[0].length;
        
        for (x = 0; x < rows; x++) {
            for (y = 0; y < cols; y++) {
                if (image[x][y] == '1') {
                    top = Math.min(top, x);
                    bottom = Math.max(bottom, x + 1);
                    left = Math.min(left, y);
                    right = Math.max(right, y + 1);
                }
            }
        }
        
        return (right - left) * (bottom - top);
    }
}
