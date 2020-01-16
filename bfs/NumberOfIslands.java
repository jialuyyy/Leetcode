//breadth first traverse the matrix, if the value is '1', do the bfs, add the current value into the queue, and iterate over the 
//four directions, if it is '1', add into the queue and set the value from '1' to '0'; else, do nothing. when the queue is empty, an island
//is found, return to the previous method and continue the loop.

//Time Complexity: O(n)
//Space Complexity: O(n)

//beats 20%
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

//union find
class Solution {
    class UnionFind {
        private int[] father = null;
        private int count = 0;
        public UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }
        
        private int find(int x) {
            if (father[x] == x)
                return x;
            
            return father[x] = find(father[x]);
        }
        
        public void connect(int x, int y) {
            int father_x = find(x);
            int father_y = find(y);
            
            if (father_x != father_y) {
                father[father_x] =father[father_y];
                this.count--;
            }
        }
        
        public void setCount(int count) {
            this.count = count;
        }
        
        public int query() {
            return this.count;
        }
        
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        int count = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //initailly we have the number of 1s connected components
                if (grid[i][j] == '1') {
                    count++;
                }
            }
        }
        UnionFind uf = new UnionFind(rows * cols);
        uf.setCount(count);
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                     if (i > 0 && grid[i - 1][j] == '1') {
                        uf.connect(i * cols + j, (i - 1) * cols + j);
                     }
                
                    if (i < rows - 1 && grid[i + 1][j] == '1') {
                        uf.connect(i * cols + j, (i + 1) * cols + j);
                    }
                
                    if (j > 0 && grid[i][j - 1] == '1') {
                        uf.connect(i * cols + j, i * cols + j - 1);
                    }
                
                    if (j < cols - 1 && grid[i][j + 1] == '1') {
                        uf.connect(i * cols + j, i * cols + j + 1);
                    }
                }
               
            }
        }
        
        return uf.query();
    }
}
