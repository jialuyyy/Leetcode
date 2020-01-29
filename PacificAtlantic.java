/do dfs from the points on for edges,
//because they are all garanteed that will be flow into the ocean
class PacificAtlantic {
    
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return ret;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, cols - 1);
        }
        
        for (int i = 0; i < cols; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, rows - 1, i);
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ret.add(list);
                }
            }
        }
        
        return ret;
    }
    
    private void dfs(int[][] matrix, boolean[][] visited, int height, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || height > matrix[i][j] || visited[i][j])
            return;
        
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int index_x = i + dx[k];
            int index_y = j + dy[k];
            
            dfs(matrix, visited, matrix[i][j], index_x, index_y);
        }
        
    }
}
