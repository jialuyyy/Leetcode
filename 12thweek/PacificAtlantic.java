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

//反向思考， 节省时间， 第一行第一列一定能到达pacific
//最后一行，最后一列一定能到达atlantic,对这两行两列的每个点做dfs，扫过的不用再扫
class Solution {
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private int rows;
    private int cols;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ret = new ArrayList<int[]>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ret;
        }
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        boolean[][] pacific = new boolean[this.rows][this.cols];
        boolean[][] atlantic = new boolean[this.rows][this.cols];
        
        for (int i = 0; i < this.rows; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i,0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i,this.cols - 1);
        }
        
        for (int i = 0; i < this.cols; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, this.rows - 1, i);
        }
        
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ret.add(new int[]{i, j});
                }
            }
        }
        
        return ret;
    }
    
    private void dfs (int[][] matrix, boolean[][] canReach, int prev, int x, int y) {
        if (x < 0 || x >= this.rows || y < 0 || y >= this.cols || prev > matrix[x][y] || canReach[x][y]) {
            return;
        }
        
        canReach[x][y] = true;
        for (int i = 0 ; i < 4; i++) {
            dfs(matrix, canReach, matrix[x][y], x + dx[i], y + dy[i]);
        }
    }
}
