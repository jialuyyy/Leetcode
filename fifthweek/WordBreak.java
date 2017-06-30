//should let dp[0] = true, as we need to consider a "team"  -> [team] this corner case should be true
//dp[i] will be true if and only if there exist a j between 0 to i, dp[j] == true and substring(j, i) is a word in the dictionary
//the result should be dp[s.length()]
//Time Complexity: O(n ^ 2)
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        
        return dp[s.length()];
    }
}
