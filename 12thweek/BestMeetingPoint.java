//brute force bfs
//time limit exceed for the last test case
//because all the points are likely to be the meeting point, different than the walls and gate and the shortest distance to buildings
class BestMeetingPoint {
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};
    private int rows;
    private int cols;
    
    class Point{
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        this.rows = grid.length;
        this.cols = grid[0].length;
        int[][] dist = new int[this.rows][this.cols];
        
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (grid[i][j] == 1) {
                    Deque<Point> queue = new ArrayDeque<Point>();
                    boolean[][] visited = new boolean[this.rows][this.cols];
                    queue.offer(new Point(i, j));
                    visited[i][j] = true;
                    int level = 1;
                    while(!queue.isEmpty()) {
                        int size = queue.size();
                        
                        for (int s = 0; s < size; s++) {
                            Point cur = queue.poll();
                            
                            for (int k = 0; k < 4; k++) {
                                int index_x = cur.x + dx[k];
                                int index_y = cur.y + dy[k];
                                
                                if (index_x >= 0 && index_x < this.rows && index_y >= 0 && index_y < this.cols && !visited[index_x][index_y]) {
                                    visited[index_x][index_y] = true;
                                    queue.offer(new Point(index_x, index_y));
                                    dist[index_x][index_y] += level;
                                }
                            }
                        }
                        level++;
                    }
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i <this.rows; i++) {
            for(int j = 0; j < this.cols; j++) {
                
                    min = Math.min(dist[i][j], min);
                
            }
        }
        
        return min = min == Integer.MAX_VALUE? 1 : min;
    }
    
//optimized solution
class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        List<Integer> x = new ArrayList<Integer>();
        List<Integer> y = new ArrayList<Integer>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        
        return getMin(x) + getMin(y);
    }
    
    private int getMin(List<Integer> list) {
        Collections.sort(list);
        int start = 0;
        int end = list.size() - 1;
        int ret = 0;
        while (start < end) {
            ret += list.get(end--) - list.get(start++);
        }
        
        return ret;
    }
}
}
