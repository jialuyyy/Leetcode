//bruth force dfs
//time limit exceeds
class PacificAtlantic {
    private int rows = 0;
    private int cols = 0;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ret = new ArrayList<int[]>();
        if (matrix == null || matrix.length == 0) {
            return ret;
        }
        
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        boolean[][] visited = null;
        
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                boolean[] pacific = new boolean[1];
                boolean[] atlantic = new boolean[1];
                if (i == 0 || j == 0) {
                    pacific[0] = true;
                } else {
                    visited = new boolean[this.rows][this.cols];
                    helperPacific(matrix, Integer.MAX_VALUE, i, j, visited, pacific);
                }
                
                if (i == this.rows - 1 || j == this.cols - 1) {
                    atlantic[0] = true;
                } else {
                    visited = new boolean[this.rows][this.cols];
                    helperAtlantic(matrix, Integer.MAX_VALUE, i, j, visited, atlantic);
                }
                
                if (pacific[0] && atlantic[0]) {
                    ret.add(new int[]{i, j});
                }
            }
        }
        
        return ret;
    }
    
    private void helperPacific(int[][] matrix, int prev, int i, int j, boolean[][] visited, boolean[] ret) {
        
        if (i < 0 || i >= this.rows || j < 0 || j >= this.cols || matrix[i][j] > prev || visited[i][j]) {
            return;
        }
        
        if (i == 0 || j == 0) {
            ret[0] = true;
            return;
        }
        
        visited[i][j] = true;
        
        helperPacific(matrix, matrix[i][j],  i + 1, j, visited, ret);
        helperPacific(matrix, matrix[i][j],i - 1, j,  visited, ret);
        helperPacific(matrix, matrix[i][j], i, j + 1,  visited, ret);
        helperPacific(matrix, matrix[i][j], i, j - 1,  visited, ret);
        
        visited[i][j] = false;
        
    }
    
    private void helperAtlantic(int[][] matrix, int prev, int i, int j, boolean[][] visited, boolean[] ret) {
        if (i < 0 || i >= this.rows || j < 0 || j >= this.cols || matrix[i][j] > prev || visited[i][j]) {
            return;
        }
        
        if (i == this.rows - 1 || j == this.cols - 1) {
            ret[0] = true;
            return;
        }
        visited[i][j] = true;
        
        helperAtlantic(matrix, matrix[i][j], i + 1, j, visited, ret);
        helperAtlantic(matrix, matrix[i][j], i - 1, j,  visited, ret);
        helperAtlantic(matrix, matrix[i][j], i, j + 1,  visited, ret);
        helperAtlantic(matrix, matrix[i][j], i, j - 1,  visited, ret);
        
        visited[i][j] = false;
    }
}
