//Solution I 
//BFS TLE
//for every element that equals 1, do a breadth first traversal to find the minimum distance, when the matrix size gets large, time limit
//exceeds, need to do some optimization
public class UpdateMatrix {
    class Pair {
        int val;
        int row;
        int col;
        
        public Pair(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
    private int[] dx = {0,0,-1,1};
    private int[] dy = {-1,1,0,0};
    private int row;
    private int col;
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[][]{};
        }
        
        int[][] ret = new int[matrix.length][matrix[0].length];
        this.row = matrix.length;
        this.col = matrix[0].length;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    ret[i][j] = 0;
                } else {
                    ret[i][j] = bfs(matrix, i, j);
                }
            }
        }
        
        return ret;
    }
    
    private int bfs(int[][] matrix, int row, int col) {
        boolean[][] hash = new boolean[this.row][this.col];
        Queue<Pair> q = new ArrayDeque<Pair>();
        q.offer(new Pair(matrix[row][col], row, col));
        hash[row][col] = true;
        int count = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                
                if (cur.val == 0) {
                    return count;
                }
                
                for (int k = 0; k < 4; k++) {
                    int next_row = cur.row + dx[k];
                    int next_col = cur.col + dy[k];
                    
                    if (next_row >= 0 && next_row < this.row && next_col >= 0 && next_col < this.col && !hash[next_row][next_col]) {
                        q.offer(new Pair(matrix[next_row][next_col], next_row, next_col));
                        hash[next_row][next_col] = true;
                    }
                }
            }
            count++;
        }
        
        return count;
    }
}
