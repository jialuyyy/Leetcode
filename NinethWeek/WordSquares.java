public class WordSquares {
    class TrieNode {
        TrieNode[] arr = new TrieNode[26];
        List<String> startsWith = new ArrayList<String>();
        String word;
    }
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ret = new ArrayList<List<String>>();
        if (words == null || words.length == 0) {
            return ret;
        }
        
        TrieNode root = new TrieNode();
        buildTrie(words, root);
        int len = words[0].length();
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            ans.add(words[i]);
            search(len, ans, ret, root);
            ans.remove(ans.size() - 1);
        }
        
        return ret;
    }
    
    private void search(int len, List<String> ans, List<List<String>> ret, TrieNode root) {
        if (ans.size() == len) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        
        int index = ans.size();
        StringBuilder prefix = new StringBuilder();
        for (String a: ans) {
            prefix.append(a.charAt(index));
        }
        
        List<String> startsWith = searchPrefix(prefix.toString(), root);
        
        for (int i = 0; i < startsWith.size(); i++) {
            ans.add(startsWith.get(i));
            search(len, ans, ret, root);
            ans.remove(ans.size() - 1);
        }
    }
    
    private void buildTrie(String[] words, TrieNode root) {
        for (int i = 0; i < words.length; i++) {
            TrieNode cur = root;
            
            char[] ch = words[i].toCharArray();
            for (char c: ch) {
                if (cur.arr[c - 'a'] == null) {
                    cur.arr[c - 'a'] = new TrieNode();
                }
                cur.arr[c - 'a'].startsWith.add(words[i]);
                cur = cur.arr[c - 'a'];
            }
            
            cur.word = words[i];
        }
    }
    
    private List<String> searchPrefix(String prefix, TrieNode root) {
        List<String> ret = new ArrayList<String>();
        if (prefix == null || prefix.length() == 0) {
            return ret;
        }
        
        TrieNode cur = root;
        
        char[] ch = prefix.toCharArray();
        for (char c: ch) {
            if (cur.arr[c - 'a'] == null) {
                return ret;
            } 
            
            cur = cur.arr[c - 'a'];
        }
        
        ret.addAll(cur.startsWith);
        
        return ret;
    }
}
