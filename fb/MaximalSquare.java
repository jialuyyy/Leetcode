//dp[i][j] = 0 if (matrix[i][j] == '0')
//else dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) + 1
//dp denotes the maximum square length that ending in point matrix[i][j]
//should do initilization for the first row and first column, if the matrix[i][j] == '0', dp should be 0; else dp should be 1
//beats 53%
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] dp = new int[rows][cols];
        int max = 0;
        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0] == '0'? 0 : 1;
            max = Math.max(max, dp[i][0]);
        }
        
        for (int i = 0; i < cols; i++) {
            dp[0][i] = matrix[0][i] == '0'? 0 : 1;
            max = Math.max(max, dp[0][i]);
        }
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                }
                
                max = Math.max(max, dp[i][j]);
            }
        }
        
        return max * max;
    }
}
