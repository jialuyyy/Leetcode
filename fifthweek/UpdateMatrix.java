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

//there is no need to do BFS for every element in the matrix, push 0 element into the matrix, and set all the 1 to Integer.MAX_VALUE,
//then poll the element one by one, check the four directions of the element, if the element is less than or equals to current value, which
//means it has already been updated, otherwise, push the element into the queue and update the value to current value + 1
//beats 69%
public class Solution {
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
        
        this.row = matrix.length;
        this.col = matrix[0].length;
        Queue<Pair>  queue = new ArrayDeque<Pair>();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new Pair(matrix[i][j], i, j));
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            
            for (int k = 0; k < 4; k++) {
                int next_row = cur.row + dx[k];
                int next_col = cur.col + dy[k];
                
                if (next_row >= 0 && next_row < this.row && next_col >= 0 && next_col < this.col) {
                    if (matrix[next_row][next_col] > cur.val + 1) {
                        matrix[next_row][next_col] = cur.val + 1;
                        queue.offer(new Pair(matrix[next_row][next_col], next_row, next_col));
                    }
                }
            }
        }
        return matrix;
    }
    
}
