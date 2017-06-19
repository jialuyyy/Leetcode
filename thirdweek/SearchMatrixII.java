//beats 60.37%
//start from the right upper most point of the matrix, if the value is greater than target value, decrease col index value; else, increase
//the row index value
//Time Complexity: O(n) n is O(row number) + O(col number)
public class SearchMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int x = 0;
        int y = cols - 1;
        
        while (x >= 0 && y < cols && x < rows && y >= 0) {
            int cur = matrix[x][y];
            
            if (cur == target) {
                return true;
            } else if (cur > target) {
                y--;
            } else {
                x++;
            }
        }
        
        return false;
    }
}
