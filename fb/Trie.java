//Create a wrapper class TrieNode which has two instance variables, one is an array of TrieNode whose length is 26, when inserting the word,
//create a TrieNode at the index ch - 'a', and when reaching the end of a word, set the isEnd to be true.
//Trie data structure saves the space compared with others
public class Trie {

    /** Initialize your data structure here. */
    class TrieNode {
        TrieNode[] arr = new TrieNode[26];
        boolean isEnd = false;
    }
    
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.arr[ch - 'a'] == null) {
                return false;
            }
            
            cur = cur.arr[ch - 'a'];
        }
        
        return cur.isEnd;
    } 
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (cur.arr[ch - 'a'] == null) {
                return false;
            }
            
            cur = cur.arr[ch - 'a'];
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
