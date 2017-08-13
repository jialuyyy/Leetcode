public class MazeII {
    class Point {
        int x;
        int y;
        int len;
        
        public Point(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};
    private int rows = 0;
    private int cols = 0;
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || start == null || destination == null) {
            return -1;
        }
        
        this.rows = maze.length;
        this.cols = maze[0].length;
        
        int[][] dist = new int[this.rows][this.cols];
        
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        Deque<Point> queue = new ArrayDeque<Point>();
        queue.offer(new Point(start[0], start[1], 0));
        
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            
           
            for (int k = 0; k < 4; k++) {
                int len = cur.len;
                int index_x = cur.x;
                int index_y = cur.y;
                
                while (isValid(index_x, index_y, maze)) {
                    index_x += dx[k];
                    index_y += dy[k];
                    len++;
                }
                
                index_x = index_x - dx[k];
                index_y = index_y - dy[k];
                len--;
                
                if (len < dist[index_x][index_y]) {
                    dist[index_x][index_y] = len;
                    queue.offer(new Point(index_x, index_y, len));
                }
            }
        }
        
        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE? -1 : dist[destination[0]][destination[1]];
    }
    
    private boolean isValid(int x, int y, int[][] maze) {
        if (x >= 0 && x < this.rows && y >= 0 && y < this.cols && maze[x][y] == 0) {
            return true;
        }
        
        return false;
    }
}
