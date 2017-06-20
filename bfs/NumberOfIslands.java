public class NumberOfIslands {
    
    class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private int rows = 0;
    private int cols = 0;
    private int[] dx = {0,0,-1,1};
    private int[] dy = {1,-1,0,0};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        this.rows = grid.length;
        this.cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void bfs (char[][] grid, int x, int y) {
        
        Queue<Point> q = new LinkedList<Point>();
        q.offer(new Point(x, y));
        grid[x][y] = '0';
        while (!q.isEmpty()) {
            Point p = q.poll();
            
            for (int k = 0; k < 4; k++) {
                int index_x = p.x + dx[k];
                int index_y = p.y + dy[k];
            
                if (index_x >= 0 && index_x < rows && index_y >= 0 && index_y < cols && grid[index_x][index_y] == '1') {
                    q.offer(new Point(index_x, index_y));
                    grid[index_x][index_y] = '0';
                }
            }
        }
    }
}
