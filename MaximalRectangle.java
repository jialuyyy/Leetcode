//dynamic programming
//dp[i][j] represents the max width ending in point(i,j) if the right most corner is point(i, j)
//iterate each point on the matrix and if matrix[i][j] == '1', dp[i][j] = dp[i][j - 1] + 1
//iterate the other points at the same column to define the current maxArea, height is (i - k + 1), width is the smaller one between
//dp[k][j] and dp[i][j]
//Time Complexity : O(N*M*N)
//N is the rows number and M is the column number, since we need to iterate over the other points on the same column for each
//point, so we need to multiply another N in this case
class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;
        int[][] dp = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                    
                    int width = dp[i][j];
                    
                    for (int k = i; k >= 0; k--) {
                        width = Math.min(width, dp[k][j]);
                        maxArea = Math.max(maxArea, width * (i - k + 1));
                    }
                }
            }
        }
        
        return maxArea;
    }
}
