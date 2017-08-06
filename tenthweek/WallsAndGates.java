public class WallsAndGates {
    class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};
    
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }
        
        Deque<Point> q = new ArrayDeque<Point>();
        int rows = rooms.length;
        int cols = rooms[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(new Point(i, j));
                }
            }
        }
        
        while (!q.isEmpty()) {
            Point cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int index_x = cur.x + dx[i];
                int index_y = cur.y + dy[i];
                
                if (index_x >= 0 && index_x < rows && index_y >= 0 && index_y < cols && rooms[index_x][index_y] == Integer.MAX_VALUE) {
                    q.offer(new Point(index_x, index_y));
                    rooms[index_x][index_y] = rooms[cur.x][cur.y] + 1;
                }
            }
        }
    }
}
