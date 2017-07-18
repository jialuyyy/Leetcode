//beats 52.98%
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            
            Set<Character> rowSet = new HashSet<Character>();
            Set<Character> colSet = new HashSet<Character>();
            Set<Character> cubeSet = new HashSet<Character>();
            
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rowSet.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !colSet.add(board[j][i]))
                    return false;
                
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cubeSet.add(board[rowIndex + j / 3][colIndex + j % 3]))                 {
                    return false;
                }
            }
            
        }
        
        return true;
    }
}
