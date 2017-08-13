//s = "leetcode"
//dict = ["leet", "code"]
//dp[0] = true; dp[4] = true; dp[8] = true;
//dp[i] denotes whether the substring(0, i) is perfect partition of the dictionary

public class WordBreakI {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        
        //s = "abc" dict = ["abc"]
        dp[0] = true;
        
        for (int i = 1; i < dp.length; i++) {
            //iterate from j = 0 to j = i - 1, if the dp[j] is true, just need to check whether substring(j, i) is in the dict
            for (int j = 0; j < i; j++) {
                if (dp[j]) {
                    String sub = s.substring(j, i);
                    if (wordDict.contains(sub)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        
        return dp[s.length()];
    }
}
