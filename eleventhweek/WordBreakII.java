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


//use dynamic programming to maintain a String list which contains all the word dictionary that ending with current index - 1
//int this example dp[0] = {""} dp[1] = {""} dp[2] ={""} dp[3] = {"cat"} dp[4] = {"cats"} dp[5] = {""} dp[6] = {""} dp[7] = //{"sand, and"} dp[8] = {""} dp[9] = {""} dp[10] = {"dog"}
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ret = new ArrayList<String>();
        if (wordDict == null || wordDict.size() == 0) 
            return ret;
        List<String>[] dp = new ArrayList[s.length() + 1];
        
        dp[0] = new ArrayList<String>();
        
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == null) {
                continue;
            }
            for (String word: wordDict) {
                int len = word.length();
                int end = i + len;
                
                if (end <= s.length()) {
                    if (word.equals(s.substring(i, end))) {
                        if (dp[end] == null) {
                            dp[end] = new ArrayList<String>();
                        }
                        dp[end].add(word);
                    }
                }
            }
        }
        
        //dfs
        if (dp[s.length()] == null) {
            return ret;
        }
        
        dfs(ret, new ArrayList<String>(), s.length() , dp);
        return ret;
    }
    
    private void dfs(List<String> ret, List<String> temp, int end, List<String>[] dp) {
        if (end == 0) {
            String path = temp.get(temp.size() - 1);
            for (int i = temp.size() - 2; i >= 0; i--)
                path += " " + temp.get(i);
            
            ret.add(path);
            return;
        }
        
        for (String str: dp[end]) {
            temp.add(str);
            dfs(ret, temp, end - str.length(), dp);
            temp.remove(temp.size() - 1);
        }
    }
}
