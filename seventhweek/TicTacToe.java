//maintain two arrays and two variables
//one array is used to keep the counters for the row while the other one is used to keep the counters for the column
//for example, rows[0] means the number of items on row 0.if player 1 put item on row 0, increase the rows[0], and if player 2 put item
//on row 0, decrease row[0], when row[0] is reaching n which means player 1 wins; otherwise, reaches -n, player 2 wins; if none of the 
//rows, cols, diagnal or anti-diagnal reaches n, no one wins.
public class TicTacToe {

    /** Initialize your data structure here. */
    private int[] rows;
    private int[] cols;
    private int diagnal;
    private int antiDiagnal;
    private int n;
    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.diagnal = 0;
        this.n = n;
        this.antiDiagnal = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (player == 1) {
            rows[row]++;
            cols[col]++;
            
            if (row == col) {
                diagnal++;
            }
            
            if (row + col == n - 1) {
                antiDiagnal++;
            }
        } else {
            rows[row]--;
            cols[col]--;
            
            if (row == col) {
                diagnal--;
            }
            
            if (row + col == n - 1) {
                antiDiagnal--;
            }
        }
        
        if (rows[row] == n || cols[col] == n || diagnal == n || antiDiagnal == n) {
            return 1;
        }
        
        if (rows[row] == -n || cols[col] == -n || diagnal == -n || antiDiagnal == -n) {
            return 2;
        }
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
