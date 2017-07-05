//use dynamic programming to maintain a String list which contains all the word dictionary that ending with current index - 1
//int this example dp[0] = {""} dp[1] = {""} dp[2] ={""} dp[3] = {"cat"} dp[4] = {"cats"} dp[5] = {""} dp[6] = {""} dp[7] = //{"sand, and"} dp[8] = {""} dp[9] = {""} dp[10] = {"dog"}
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ret = new ArrayList<String>();
        if (wordDict == null || wordDict.size() == 0) 
            return ret;
        List<String>[] dp = new ArrayList[s.length() + 1];
        
        dp[0] = new ArrayList<String>();
        
        for (int i = 0; i < dp.length; i++) {
            //this is because the perfect partition only take place when current dp string list contains some valid strings from
            //dict, if current is null, which means previous substrings cannot make a string contained in the dict
            
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
        //no valid perfect partition
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
        
        //traverse from the last dp string list, traverse each string in the list, every time decrease the length of the string
        //if it reaches 0, which means we find a valid result
        for (String str: dp[end]) {
            temp.add(str);
            dfs(ret, temp, end - str.length(), dp);
            temp.remove(temp.size() - 1);
        }
    }
    
    
    // isWord maintains whether s.substring(i, j + 1) is in the dictionary
    //isPossible maintains whether index from i to the end will be a possible perfect partition
    //if isPossible[0] = false, which means there is no perfect partition of the input string
    // if isPossible[0] is true, which means there exists perfect partition given the input string
    //if the startIndex == s.length(), which means we already found one solution and put it int the result list
    //else, iterate over from the startIndex, if found a word, iterate recursively until found a valid solution
    
    public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ret = new ArrayList<String>();
        if (s == null || wordDict == null) {
            return ret;
        }
        
        boolean[][] isWord = new boolean[s.length()][s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (wordDict.contains(s.substring(i, j + 1))) {
                    isWord[i][j] = true;
                }
            }
        }
        
        boolean[] isPossible = new boolean[s.length() + 1];
        isPossible[s.length()] = true;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (isWord[i][j] && isPossible[j + 1]) {
                    isPossible[i] = true;
                    break;
                }
            }
        }
        
        search(isWord, isPossible, 0, new ArrayList<Integer>(), ret, s);
        return ret;
    }
    
    private void search(boolean[][] isWord, boolean[] isPossible, int startIndex, List<Integer> path, List<String> ret, String s) {
        if (!isPossible[startIndex]) {
            return;
        }
        
        if (startIndex == s.length()) {
            StringBuilder sb = new StringBuilder();
            int lastIndex = 0;
            for (int i = 0; i < path.size(); i++) {
                sb.append(s.substring(lastIndex, path.get(i)));
                if (i != path.size() - 1) {
                    sb.append(" ");
                }
                lastIndex = path.get(i);
            }
            
            ret.add(sb.toString());
        }
        
        for (int i = startIndex; i < s.length(); i++) {
            if (!isWord[startIndex][i]) {
                continue;
            }
            
            path.add(i + 1);
            search(isWord, isPossible, i + 1, path, ret, s);
            path.remove(path.size() - 1);
        }
        
    }
}
}
