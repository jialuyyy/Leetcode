class ShortestDistFromAllBuildings {
    
    private int rows = 0;
    private int cols = 0;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    
    class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        
        this.rows = grid.length;
        this.cols = grid[0].length;
        
        //need to maintain a reached boolean array to keep the number of the buildings that can reach empty slot, if the
        //number of the buildings is not the actual number of buildings, which means some of the buildings the slot cannot 
        //reach, so the total distance for this empty slot will be invalid.
        
        int[][] numberOfBuildings = new int[rows][cols];
        int[][] dist = new int[rows][cols];
        int buildingNumber = 0;
        boolean[][] visited = null;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    buildingNumber++;
                    visited = new boolean[rows][cols];
                    Deque<Point> q = new ArrayDeque<Point>();
                    q.offer(new Point(i, j));
                    visited[i][j] = true;
                    int level = 1;
                    while (!q.isEmpty()) {
                        int size = q.size();
                        
                        for (int k = 0; k < size; k++) {
                            Point cur = q.poll();
                            
                            for (int index = 0; index < 4; index++) {
                                int index_x = cur.x + dx[index];
                                int index_y = cur.y + dy[index];
                                
                                if (index_x >= 0 && index_x < rows && index_y >= 0 && index_y < cols && grid[index_x][index_y] == 0 && !visited[index_x][index_y]) {
                                    dist[index_x][index_y] += level;
                                    numberOfBuildings[index_x][index_y]++;
                                    q.offer(new Point(index_x, index_y));
                                    visited[index_x][index_y] = true;
                                }
                            }
                        }
                        
                        level++;
                    }
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (grid[i][j] == 0 && numberOfBuildings[i][j] == buildingNumber)
                    min = Math.min(min, dist[i][j]);
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
