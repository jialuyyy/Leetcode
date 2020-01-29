class LongestIncreasingPath {
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
        for (int k = 0; k < 4; k++) {
            int index_x = i + dx[k];
            int index_y = j + dy[k];
            if (index_x < 0 || index_x >= matrix.length || index_y < 0 || index_y >= matrix[0].length || matrix[index_x][index_y] <= matrix[i][j])
                continue;
            
            
            cache[i][j] = Math.max(cache[i][j], dfs(matrix, index_x, index_y, cache));
        }
        
        return ++cache[i][j];
    }
}
