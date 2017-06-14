//beats 58.60%
//Time Complexity O(n ^ n)

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<List<String>>();
        if (n == 0) {
            return ret;
        }
        
        helper(new ArrayList<Integer>(), ret, n, 0);
        return ret;
    }
    
    private void helper(List<Integer> colPos, List<List<String>> ret, int n, int row) {
        if (colPos.size() == n) {
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < colPos.size(); i++) {
                int pos = colPos.get(i);
                char[] board = new char[n];
                Arrays.fill(board, '.');
                board[pos] = 'Q'; 
                list.add(String.valueOf(board));
            }
            ret.add(list);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (isValid(colPos, row, i)) {
               colPos.add(i);
               helper(colPos, ret, n, row + 1);
               colPos.remove(colPos.size() - 1);
            }
        }
    }
    
    private boolean isValid(List<Integer> colPos, int row, int col) {
        for (int i = 0; i < colPos.size(); i++) {
            if (colPos.get(i) == col) {
                return false;
            }
            
            if (row + col == colPos.get(i) + i) {
                return false;
            }
            
            if (row - col == i - colPos.get(i)) {
                return false;
            }
        }
        
        return true;
    }
}
