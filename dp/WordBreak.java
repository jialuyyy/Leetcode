//dp[i] = true
//if and only if these exists one j
//dp[j](j >= 0 && j < i) && wordDict.contains(string.substring(j,i))
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
