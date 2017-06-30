//beats 63.33%
//use an arraylist to represent the list of String, array index represents rowIndex while array element represents colIndex
//dfs, while the arrayList.size() == n, which means we already find a valid result and add it to the result list
//else, check the next element in the same row, while get to the end of each row, remove the last element of the list and backtrack to
//the previous row.

public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<List<String>>();
        if (n <= 0) {
            return ret;
        }
        
 
        helper(ret, new ArrayList<Integer>(), 0, n);
        
        
        return ret;
    }
    
    private void helper(List<List<String>> ret, List<Integer> colPosList, int rowIndex, int n) {
        if (colPosList.size() == n) {
            List<String> temp = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                char[] tmp = new char[n];
                Arrays.fill(tmp, '.');
                int queenCol = colPosList.get(i);
                tmp[queenCol] = 'Q';
                temp.add(String.valueOf(tmp));
            }
            ret.add(temp);
            return;
        }    
        
        for (int j = 0; j < n; j++) {
            if (isValid(colPosList, j, rowIndex)) {
                colPosList.add(j);
                helper(ret, colPosList, rowIndex + 1, n);
                colPosList.remove(colPosList.size() - 1);
            }
        }
        
    }
    
    private boolean isValid(List<Integer> colPosList, int colIndex, int rowIndex) {
        for (int row = 0; row < colPosList.size(); row++) {
            int col = colPosList.get(row);
            
            //check whether the same col
            if (col == colIndex) {
                return false;
            }
            
            //check the diagonal
            if (colIndex - col == rowIndex - row) {
                return false;
            }
            
            if (colIndex + rowIndex == row + col) {
                return false;
            }
        }
        
        return true;
    }
}
