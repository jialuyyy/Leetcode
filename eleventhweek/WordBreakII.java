//Time Limit Exceeds

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ret = new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        
        for (String word: wordDict) {
            set.add(word);
        }
        
        helper(s, set, ret, "", 0);
        return ret;
    }
    
    private void helper(String s, Set<String> set, List<String> ret, String str, int pos) {
        if (pos == s.length()) {
            ret.add(str);
            return;
        }
        
        if (pos > s.length()) {
            return;
        }
        int i = pos;
        for (int j = i + 1; j <= s.length(); j++) {
            String sub = s.substring(i, j);
            if (set.contains(sub)) {
                if (i == 0) {
                    helper(s, set, ret, str + sub, j);
                } else {
                    helper(s, set, ret, str + " " + sub, j);
                }
            }
        }
        
    }
}
