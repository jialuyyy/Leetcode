class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        
        //build trie
        TrieNode root = new Trie().buildTrie(words);
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(i, j, root, board, res);
            }
        }
        return res;
    }
    
    
    private void dfs(int i, int j, TrieNode cur, char[][] board, List<String> res) {
        char c = board[i][j];
        if (c == '#' || cur.trieNode[c - 'a'] == null)
            return;
        cur = cur.trieNode[c - 'a'];
        if (cur.word != null) {
            res.add(cur.word);
            //avoid duplicates
            cur.word = null;
        }
        board[i][j] = '#';
        if (i - 1 >= 0)
            dfs(i - 1, j, cur, board, res);
        if (i + 1 < board.length)
            dfs(i + 1, j, cur, board, res);
        if (j - 1 >= 0)
            dfs(i, j - 1, cur, board, res);
        if (j + 1 < board[0].length)
            dfs(i, j + 1, cur, board, res);
        board[i][j] = c;
        
    }
    class Trie {
        private TrieNode root = new TrieNode();
        public TrieNode buildTrie(String[] words) {    
            for (String word : words) {
                TrieNode cur = root;
                char[] ch = word.toCharArray();
                for (char c : ch) {
                    if (cur.trieNode[c - 'a'] == null)
                        cur.trieNode[c - 'a'] = new TrieNode();
                    cur = cur.trieNode[c - 'a'];
                }
                cur.word = word;
            }
            
            return root;
        }
    }
    class TrieNode {
        TrieNode[] trieNode = new TrieNode[26];
        String word = null;
    }
}
