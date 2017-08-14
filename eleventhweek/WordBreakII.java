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


//use a hashmap to avoid time limit exceeds
public class Solution {
    private Map<String, List<String>> map = new HashMap<String, List<String>>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (map.containsKey(s))
		    return map.get(s);

	    LinkedList<String> res = new LinkedList<String>();
	    if (s.length() == 0) {
		    res.add("");
		    return res;
	    }
	    for (String word : wordDict) {
		    if (s.startsWith(word)) {
			    List<String> sublist = wordBreak(s.substring(word.length()), wordDict);
			    for (String sub : sublist)
				    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
		    }
	    }
	    map.put(s, res);
	    return res;
    }
}
