class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] temp = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    for (int m = 0; m < rows; m++) {
                        temp[m][j] = -1;
                    } 
                    
                    for (int n = 0; n < cols; n++) {
                        temp[i][n] = -1;
                    }
                }
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (temp[i][j] == 0) {
                   temp[i][j] = matrix[i][j];
                } else {
                    temp[i][j] = 0;
                }
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
        
        
    }
}
