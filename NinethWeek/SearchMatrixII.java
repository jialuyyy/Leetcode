public class SearchMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        // the right top most value
        int row = 0;
        int col = matrix[0].length - 1;
        
        
        
        while (row < matrix.length && col >= 0) {
            int cur = matrix[row][col];
            if (cur > target) {
                col--;
            } else if (cur < target) {
                row++;
            } else {
                return true;
            }
        }
        
        return false;
        
        
    }
}
