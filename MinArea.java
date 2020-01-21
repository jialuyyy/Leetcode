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

class MinArea {
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0)
            return 0;
        
        int rows = image.length;
        int cols = image[0].length;
        
        int left = searchLeft(image, 0, y); //rowslog(cols)
        int right = searchRight(image, y, cols - 1);
        
        int top = searchTop(image, 0, x);
        int bottom = searchBottom(image, x, rows - 1);//colslog(rows)
        
        return (right - left + 1) * (bottom - top + 1);
    }
    
    private int searchLeft(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (isEmptyCol(mid, image)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (isEmptyCol(start, image)) {
            return end;
        }
        
        return start;
    }
    
    private int searchRight(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (isEmptyCol(mid, image)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (isEmptyCol(end, image)) {
            return start;
        }
        
        return end;
    }
    
    private int searchTop(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (isEmptyRow(mid, image)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (isEmptyRow(start, image)) {
            return end;
        }
        
        return start;
    }
    
    private int searchBottom(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (isEmptyRow(mid, image)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (isEmptyRow(end, image)) {
            return start;
        }
        
        return end;
    }
    
    private boolean isEmptyRow(int row, char[][] image) {
        for (int i = 0; i < image[0].length; i++) {
            if (image[row][i] == '1')
                return false;
        }
        
        return true;
    }
    private boolean isEmptyCol(int col, char[][] image) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][col] == '1')
                return false;
        }
        
        return true;
    }
}
