//beats 28.79
//build a trie tree when searching word
//for the search method, use BFS to cope with the special '.' case
//Time Complexity: addWord O(n) n is the length of the input word
//search word O(n) n is the length of the input word
public class WordDictionary {

    /** Initialize your data structure here. */
    class TrieNode {
        TrieNode[] arr = new TrieNode[26];
        boolean isEnd = false;
    }
    
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.arr[ch - 'a'] == null) {
                cur.arr[ch - 'a'] = new TrieNode();
            }
            cur = cur.arr[ch - 'a'];
        }
        
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        
        Deque<TrieNode> queue = new ArrayDeque<TrieNode>();
        queue.offer(root);
        int i = 0;
        
        while (!queue.isEmpty()){
            int size = queue.size();
            
            for (int j = 0; j < size; j++) {
                TrieNode cur = queue.poll();
                if (i == word.length()) {
                    if (cur.isEnd) {
                        return true;
                    }
                }
                if (i < word.length()) {
                    char ch = word.charAt(i);
                    if (ch != '.') {
                        if (cur.arr[ch - 'a'] != null)
                            queue.offer(cur.arr[ch - 'a']);
                    } else {
                        
                            for (TrieNode n: cur.arr) {
                                if (n != null)
                                queue.offer(n);
                            }
                    }
                }
                
            }
            i++;
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
