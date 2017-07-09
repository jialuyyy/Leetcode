//not in place
public class RotateImage {
    public void rotate(int[][] matrix) {
        //not in place
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] tmp = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tmp[j][rows - 1 - i] = matrix[i][j];
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = tmp[i][j];
            }
        }
    }
}

//in place

public class Solution {
    /* 1 2 3
       4 5 6
       7 8 9 */
    
    /* 1 4 7
       2 5 8
       3 6 9 */
   
    /* 7 4 1
       8 5 2
       9 6 3 */
    
    public void rotate(int[][] matrix) {
        //not in place
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < cols; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][cols - 1 - j];
                matrix[i][cols - 1 - j] = tmp;
            }
        }
        
    }
}
