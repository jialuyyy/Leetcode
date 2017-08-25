class MinAbbreviation {
    class TrieNode {
        boolean isEnd;
        TrieNode[] trie = null;
        
        public TrieNode() {
            isEnd = false;
            trie = new TrieNode[26];
        }
    }
    public String minAbbreviation(String target, String[] dictionary) {
        TrieNode root = new TrieNode();
        
        for (String word: dictionary) {
            if (word.length() == target.length()) {
                insert(root, word);
            }
        }
        
        int minLen = 1;
        int maxLen = target.length();
        
        String ret = null;
        
        while (minLen <= maxLen) {
            boolean isConflict = true;
            int mid = minLen + (maxLen - minLen) / 2;
            
            List<String> abbreviations = new ArrayList<String>();
            findAbbreviations(0, mid, new StringBuilder(), abbreviations, target);
            for (String abbreviation: abbreviations) {
                if (!isConflict(abbreviation, root, 0)) {
                    isConflict = false;
                    ret = abbreviation;
                    break;
                }
            }
            
            if (isConflict) {
                minLen= mid + 1;
            } else {
                maxLen = mid - 1;
            }
        }
        
        return ret;
    }
    
    private void insert(TrieNode root, String word) {
        TrieNode cur = root;
        char[] ch = word.toCharArray();
        
        for (int i = 0; i < ch.length; i++) {
            if (cur.trie[ch[i] - 'a'] == null)
                cur.trie[ch[i] - 'a'] = new TrieNode();
            cur = cur.trie[ch[i] - 'a'];
        }
        cur.isEnd = true;
    }
    
    private boolean isConflict(String abbreviation, TrieNode node, int num) {
        if (num > 0) {
            for (TrieNode next: node.trie) {
                if (next != null && isConflict(abbreviation, next, num - 1)) {
                    return true;
                }
            }
            
            return false;
        } else {
            if (abbreviation.length() == 0) {
                return node.isEnd;
            }
            
            int i = 0;
            for (; i < abbreviation.length() && abbreviation.charAt(i) >= '0' && abbreviation.charAt(i) <= '9'; i++) {
                num = num * 10 + (abbreviation.charAt(i) - '0');
            }
            
            if (i != 0) {
                return isConflict(abbreviation.substring(i), node, num);
            } else {
                TrieNode next = node.trie[abbreviation.charAt(0) - 'a'];
                if (next == null) {
                    return false;
                }
                
                return isConflict(abbreviation.substring(1), next, num);
            }
        }
    }
    
    
    private void findAbbreviations(int s, int len, StringBuilder sb, List<String> abbrs, String target) {
        if (s >= target.length()) return; 
        boolean prevNum = (sb.length() > 0 && sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9');
        
        if (len == 1) { 
            if (s == target.length() - 1) abbrs.add(sb.append(target.charAt(s)).toString());
            else if (!prevNum) { 
                abbrs.add(sb.append(target.length() - s).toString());
            }
        } else {
            int endIdx = sb.length(); 
            sb.append(target.charAt(s));
            findAbbreviations(s + 1, len - 1, sb, abbrs, target);
            sb.delete(endIdx, sb.length());
            
            for (int i = s + 1; i < target.length(); i++) {
                if (!prevNum) { 
                    sb.append(i - s);
                    findAbbreviations(i, len - 1, sb, abbrs, target);
                    sb.delete(endIdx, sb.length());
                }
            }
        }
    }
}
