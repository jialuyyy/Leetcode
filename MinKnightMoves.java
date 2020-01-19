class MinKnightMoves {
    
    class Point {
        private int x;
        private int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    private int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    public int minKnightMoves(int x, int y) {
        //the chessboard is symmetric
        x = Math.abs(x);
        y = Math.abs(y);
        Deque<Point> queue = new ArrayDeque<>();
        
        Set<String> visited = new HashSet<>();
        Point p = new Point(0, 0);
        queue.offer(p);
        visited.add("0,0");
        
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();
                if (cur.x == x && cur.y == y) {
                    return dist;
                }
                
                for (int k = 0; k < 8; k++) {
                    int index_x = cur.x + dx[k];
                    int index_y = cur.y + dy[k];
                    
                    //if out of bound, continue
                    if (index_x < -1 || index_y < -1 || index_x >= 310 || index_y >= 310)
                        continue;
                    
                    //otherwise
                    Point newP = new Point(index_x, index_y);
                    
                    if (!visited.contains(index_x + "," + index_y)) {
                        queue.offer(newP);
                        visited.add(index_x + "," + index_y);
                    }
                }
            }
            
            dist += 1;
        }
        
        return dist;
    }
}
