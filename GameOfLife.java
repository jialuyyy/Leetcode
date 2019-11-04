class GameOfLife {
    private int[] dx = {0, 0, -1, -1, -1, 1, 1, 1};
    private int[] dy = {-1, 1, -1, 0, 1, -1, 1, 0};
    public void gameOfLife(int[][] board) {
        if( board == null || board.length == 0 || board[0].length == 0)
            return;
        int rows = board.length;
        int cols = board[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = calculate(i, j, rows, cols, board);
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] > 0)
                    board[i][j] = 1;
                else 
                    board[i][j] = 0;
            }
        }
        
        
    }
    
    
    private int calculate(int i, int j, int rows, int cols, int[][] board) {
        int alive = 0;
        
        for (int k = 0; k < 8; k++) {
            int index_x = dx[k] + i;
            int index_y = dy[k] + j;
            
            if (index_x >= 0 && index_x < rows && index_y >= 0 && index_y < cols &&
               Math.abs(board[index_x][index_y]) == 1) {
                 alive++;
            }
        }
        
        if (board[i][j] == 1 && (alive < 2 || alive > 3)) {
            return -1;
        }
        
        
        if (board[i][j] == 0 && alive == 3) {
            return 2;
        }
        
        return board[i][j];
    }
}
