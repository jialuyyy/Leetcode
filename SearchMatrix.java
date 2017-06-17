//O(log(n))
//beats 75%
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int start = 0;
        int end = rows * cols - 1;
        
        while (start + 1 < end) {
            int mid = (start + end) >>> 1;
            
            int row = mid / cols;
            int col = mid % cols;
            
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (matrix[start / cols][start % cols] == target || matrix[end / cols][end % cols] == target) {
            return true;
        }
        
        return false;
        
    }
}
