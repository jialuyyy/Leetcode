//the 'O' that cannot be flipped to 'X' is connected to the boundary
public class SurroundedRegions {
    
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
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        
        int rows = board.length;
        int cols = board[0].length;
        
        for (int i = 0; i < cols; i++) {
            bfs(board, 0, i);
            bfs(board, rows - 1, i);
        }
        
        for (int i = 0; i < rows; i++) {
            bfs(board, i, 0);
            bfs(board, i, cols - 1);
        }
        
        for (int i = 0; i < rows; i++) {
            for( int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') 
                    board[i][j] = 'X';
                
                if (board[i][j] == '1')
                    board[i][j] = 'O';
                
            }
        }
    }
    
    private void bfs (char[][] board, int i, int j) {
        if (board[i][j] != 'O') {
            return;
        }
        
        Deque<Point> q = new ArrayDeque<Point>();
        q.offer(new Point(i, j));
        board[i][j] = '1';
        
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int index_x = cur.x + dx[k];
                int index_y = cur.y + dy[k];
                
                if (isValid(index_x, index_y, board)) {
                    q.offer(new Point(index_x, index_y));
                    board[index_x][index_y] = '1';
                }
            }
        }
    }
    
    private boolean isValid(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return false;
        }
        
        return true;
    }
}
