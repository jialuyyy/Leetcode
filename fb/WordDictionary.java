//use Trie data structure to do add and search, as it saves a lot of space
//the instance of a TrieNode contains an 26 size TrieNode arr and a boolean to denote if it is the end of a word or not
//beats 83.93%
public class WordDictionary {

    /** Initialize your data structure here. */
    TrieNode root = null;
    class TrieNode {
        TrieNode[] arr;
        boolean isEnd;
        
        public TrieNode () {
            arr = new TrieNode[26];
            isEnd = false;
        }
    }
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null) {
            return;
        }
        
        char[] ch = word.toCharArray();
        TrieNode cur = root;
        for (char c: ch) {
            if (cur.arr[c - 'a'] == null) {
                cur.arr[c - 'a'] = new TrieNode();
            }
            cur = cur.arr[c - 'a'];
        }
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        
        return find(word, 0, root);
    }
    
    private boolean find(String word, int index, TrieNode root) {
        if (index == word.length()) {
            return root.isEnd;
        }
        
        char ch = word.charAt(index);
        
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (root.arr[i] != null) {
                    if (find(word, index + 1, root.arr[i]))
                        return true;
                }
            }
            
            return false;
        } else {
            if (root.arr[ch - 'a'] == null) {
                return false;
            } else {
                return find(word, index + 1, root.arr[ch - 'a']);
            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

class WordDictionary {

    /** Initialize your data structure here. */
    class TrieNode {
        Map<Character, TrieNode> map = new HashMap<>();
        boolean isWord = false;
    }
    private TrieNode root = null;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() == 0)
            return;
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            if (cur.map.get(word.charAt(i)) == null) {
                cur.map.put(word.charAt(i), new TrieNode());
            }
            
            cur = cur.map.get(word.charAt(i));
        }
        
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] ch, int k, TrieNode node) {
        if (k == ch.length) {
            return node.isWord;
        }
        
        if (ch[k] != '.') {
            return node.map.get(ch[k]) != null && match(ch, k + 1, node.map.get(ch[k]));
        } else {
            for (char c : node.map.keySet()) {
                if (match(ch, k + 1, node.map.get(c)))
                    return true;
            }
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
