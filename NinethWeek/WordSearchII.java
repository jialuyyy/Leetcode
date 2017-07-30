public class WordSearchII {
    private int rows = 0;
    private int cols = 0; 
    
    class TrieNode {
        TrieNode[] arr = new TrieNode[26];
        String word;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ret = new ArrayList<String>();
        
        if (board == null || words == null) {
            return ret;
        }
        
        this.rows = board.length;
        this.cols = board[0].length;
        
        //build a trie so that no need to do dfs for every word, the trie tree can be used to prune
        
        TrieNode root = buildTrie(words);
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, root, ret);
            }
        }
        
        return ret;
        
    }
    
    private void dfs (char[][] board, int i, int j, TrieNode root, List<String> ret) {
        //out of bound
        //or current character is already visited
        if (i < 0 || i >= this.rows || j < 0 || j >= this.cols || board[i][j] == '#') {
            return;
        }
                                                                                      
        char c = board[i][j];
        
        //for current character, there are no words in the dictionary found
        if (root.arr[c - 'a'] == null) {
            return;
        }
        
        //one valid word found ! set the word to be null to reduce duplicates
        if (root.arr[c - 'a'].word != null) {
            ret.add(root.arr[c - 'a'].word);
            root.arr[c - 'a'].word = null;
        }
        
        board[i][j] = '#';
        
        root = root.arr[c - 'a'];
        
        dfs(board, i + 1, j, root, ret);
        dfs(board, i - 1, j, root, ret);
        dfs(board, i, j + 1, root, ret);
        dfs(board, i, j - 1, root, ret);
        
        board[i][j] = c;
        
        
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        TrieNode cur = null;
        for (String word: words) {
            char[] ch = word.toCharArray();
            cur = root;
            for (char c: ch) {
                if (cur.arr[c - 'a'] == null) {
                    cur.arr[c - 'a'] = new TrieNode();
                }
                
                cur = cur.arr[c - 'a'];
            }
            
            cur.word = word;
        }
        
        return root;
    }
}
