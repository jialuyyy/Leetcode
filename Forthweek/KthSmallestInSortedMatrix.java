//use a minheap to maintain the min value of the matrix. use a hash boolean two-dimensional matrix to avoid duplicates
//Time Complexity: klog(k)
public class KthSmallestInSortedMatrix {
    private static int[] dx = {0, 1};
    private static int[] dy = {1, 0};
    class Point {
        int x;
        int y;
        int val;
        
        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        Queue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>(){
            public int compare(Point p1, Point p2) {
                return p1.val - p2.val;
            }
        });
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        boolean[][] hash = new boolean[rows][cols];
        Point p = new Point(0,0,matrix[0][0]);
        
        pq.offer(p);
        hash[0][0] = true;
        
        for (int i = 0; i < k - 1; i++) {
            Point cur = pq.poll();
            
            for (int j = 0; j < 2; j++) {
                int index_x = cur.x + dx[j];
                int index_y = cur.y + dy[j];
                if (index_x >= 0 && index_x < matrix.length && index_y >= 0 && index_y < matrix[0].length && !hash[index_x][index_y]) {
                    Point next = new Point(index_x, index_y, matrix[index_x][index_y]);
                    
                    pq.offer(next);
                    hash[index_x][index_y] = true;
                    
                }
            }
        }
        
        return pq.poll().val;
    }
}
