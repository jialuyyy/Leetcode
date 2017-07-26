//dfs to try every '.' grid on the board from '1' to '9', if none of them is valid, return false; else, try next grid on board
//if one of '1' to '9' is invalid, reset the board[i][j] back to '.' and continue the process.

public class SolveSudoku {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        
        solve(board);
        
    }
    
    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(i, j, c, board)) {
                            board[i][j] = c;
                            
                            if (solve(board)){
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                            
                            
                        }
                    }
                    
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValid(int i, int j, char c, char[][] board) {
        for (int k = 0; k < 9; k++) {
            if (board[k][j] == c) {
                return false;
            }
            
            if (board[i][k] == c) {
                return false;
            }
            
            if(board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] == c) return false; 
            
            
        }
        return true;
    }
}
