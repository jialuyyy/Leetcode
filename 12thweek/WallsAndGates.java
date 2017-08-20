//reverse bfs. did this problem before, similar thoughts with the shortest distance to buildings

class WallsAndGates {
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
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};
    
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }
        
        this.rows = rooms.length;
        this.cols = rooms[0].length;
        
        Deque<Point> queue = null;
        
        //put all gate into the queues first
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    
                    queue = new ArrayDeque<Point>();
                    queue.offer(new Point(i, j));
                    int level = 1;
                    
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        
                        for (int s = 0; s < size; s++) {
                            Point cur = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int index_x = cur.x + dx[k];
                                int index_y = cur.y + dy[k];
                                
                                if (index_x >= 0 && index_y >= 0 && index_x < this.rows && index_y < this.cols && level < rooms[index_x][index_y]) {
                                    rooms[index_x][index_y] = level;
                                    queue.offer(new Point(index_x, index_y));
                                }
                            }
                        }
                        
                        level++;
                    }
                }
            }
        }
        
           
        
        
        
        
    }
}
