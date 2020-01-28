class MaxAreaOfIsland {
    private int maxArea = 0;
  
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][]  visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    visited = new boolean[rows][cols];
                    maxArea = Math.max(maxArea, dfs(grid, i, j, visited));
                }
            }
        }
        
        return maxArea;
    }
    
    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] != 1) {
            return 0;
        }
        
        visited[i][j] = true;
        
        return 1 + dfs(grid, i + 1, j, visited) + dfs(grid, i - 1, j, visited) + dfs(grid, i, j - 1, visited) + dfs(grid, i, j + 1, visited);
    }
}
