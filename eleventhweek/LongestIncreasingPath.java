/*
matrix
9, 9, 4
6, 6, 8
2, 1, 1

retMatrix
1, 1, 2
2, 2, 1
3, 4, 2

*/
public class LongestIncreasingPath {
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] retMatrix = new int[rows][cols];
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(helper(matrix, retMatrix, i, j, rows, cols), max);
            }
        }
        
        return max;
        
    }
    
    private int helper(int[][] matrix, int[][] retMatrix, int i, int j, int rows, int cols) {
        if (retMatrix[i][j] != 0) {
            return retMatrix[i][j];
        }
        
        int max = 1;
        for (int k = 0; k < 4; k++) {
            int index_x = i + dx[k];
            int index_y = j + dy[k];
            
            if (index_x >= 0 && index_x < rows && index_y >= 0 && index_y < cols && matrix[index_x][index_y] > matrix[i][j]) {
                max = Math.max(max, helper(matrix, retMatrix, index_x, index_y, rows, cols) + 1);
            }
        }
        
        retMatrix[i][j] = max;
        return max;
    }
}

class Solution {
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = 0;
        int[][] cache = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, dfs(matrix, i, j, cache));
            }
        }
        
        return max;
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0)
            return cache[i][j];
        int max = 1;
        for (int k = 0; k < 4; k++) {
            int index_x = i + dx[k];
            int index_y = j + dy[k];
            if (index_x < 0 || index_x >= matrix.length || index_y < 0 || index_y >= matrix[0].length || matrix[index_x][index_y] <= matrix[i][j])
                continue;
            
             int len = 1 + dfs(matrix, index_x, index_y, cache);
             max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }
}
