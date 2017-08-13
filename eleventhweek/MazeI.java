public class MazeI {
    class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1 ,1, 0, 0};
    private int rows = 0;
    private int cols = 0;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || start == null || destination == null) {
            return false;
        }
        
        this.rows = maze.length;
        this.cols = maze[0].length;
        
        Deque<Point> queue = new ArrayDeque<Point>();
        boolean[][] set = new boolean[this.rows][this.cols];
        queue.offer(new Point(start[0], start[1]));
        set[start[0]][start[1]] = true;
        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            
            if (cur.x == destination[0] && cur.y == destination[1]) {
                return true;
            }
            for (int k = 0; k < 4; k++) {
                int index_x = cur.x + dx[k];
                int index_y = cur.y + dy[k];
                
                while(isValid(index_x, index_y, maze)) {
                    index_x += dx[k];
                    index_y += dy[k];
                }
                
                index_x = index_x - dx[k];
                index_y = index_y - dy[k];
                
                if (!set[index_x][index_y]) {
                    queue.offer(new Point(index_x, index_y));
                    set[index_x][index_y] = true;
                }
            }
        }
        
        return false;
    }
    
    private boolean isValid(int x, int y, int[][] maze) {
        if (x >= 0 && x < this.rows && y >= 0 && y < this.cols && maze[x][y] == 0) {
            return true;
        }
        
        return false;
    }
}
