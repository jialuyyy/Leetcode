//beats 69.77%
//dfs backtracking problem, check four directions for every spot and if one direction is invalid, back track to another direction, set the 
//character to be '#' if it is visited and when back tracking, set it back.
public class WordSearchI {
 
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.length() == 0 || board.length == 0) {
            return false;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfsSearch(board, word, i, j, 0))
                        return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfsSearch(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        board[i][j] = '#';
        boolean ret = dfsSearch(board, word, i + 1, j, index + 1) || dfsSearch(board, word, i - 1, j, index + 1) || dfsSearch(board, word, i, j + 1, index + 1) || dfsSearch(board, word, i, j - 1, index + 1);
        
        board[i][j] = word.charAt(index);
        return ret;
           
        
    }
}
