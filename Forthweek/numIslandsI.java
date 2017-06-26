//beats 25.65%
//bfs, offer all the adjacent islands into the queue and set the char element to be '0' once the island is visited to avoid duplicate calculation
//Time complexity: O(V + E)
//Space Complexity: O(n)

public class numIslandsI {
    private static int rows;
    private static int cols;
    private int[] dx = {0,0,-1,1};
    private int[] dy = {-1,1,0,0};
    class Point{
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        rows = grid.length;
        cols = grid[0].length;
        int count = 0;
        
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
    
    private void bfs(char[][] grid, int i, int j) {
        Queue<Point> q = new ArrayDeque<Point>();
        q.offer(new Point(i, j));
        grid[i][j] = '0';
        
        while(!q.isEmpty()) {
            Point cur = q.poll();
            
            for (int k = 0; k < 4; k++) {
                int index_x = cur.x + dx[k];
                int index_y = cur.y + dy[k];
                
                if (index_x >= 0 && index_x < rows && index_y >= 0 && index_y < cols && grid[index_x][index_y] == '1') {
                    q.offer(new Point(index_x, index_y));
                    grid[index_x][index_y] = '0';
                }
            }
        }
        
    }
}


//dfs 33.80%
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs (char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') {
            return;
        }
        
        grid[x][y] = '0';
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
    }
}
