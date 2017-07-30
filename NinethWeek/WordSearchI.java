public class WordSearchI {
    private int rows = 0;
    private int cols = 0;
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || board.length == 0) {
            return false;
        }
        
        this.rows = board.length;
        this.cols = board[0].length;
        
        boolean[][] visited = new boolean[this.rows][this.cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, i, j, word, 0, visited))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, String word, int pos, boolean[][] visited) {
        
        if (pos == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= this.rows || j < 0 || j >= this.cols || word.charAt(pos) != board[i][j] || visited[i][j]) {
            return false;
        }
        
        visited[i][j] = true;
        
        boolean ret = dfs(board, i + 1, j, word, pos + 1, visited) || dfs(board, i - 1, j, word, pos + 1, visited) ||
        dfs(board, i, j + 1, word, pos + 1, visited) || dfs(board, i, j - 1, word, pos + 1, visited);
        
        visited[i][j] = false;
        
        return ret;
    }
}
