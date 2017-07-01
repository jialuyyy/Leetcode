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
}
