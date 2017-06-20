//beats 77.48%
//dp[i][j] means whether s [0, i - 1] matches p[0][j - 1]

public class IsMatch {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        
        dp[0][0] = true;
        
        //dp[i][0] is always false
        //dp[0][2i - 1] is always false
        
        //initialize dp[0][2i] with '*' as the condition
        for (int j = 1; j < p.length(); j += 2) {
            if (p.charAt(j) == '*')
                dp[0][j + 1] = dp[0][j - 1];
        }
        
        for (int j = 1; j <= s.length(); j++) {
            for (int k = 1; k <= p.length(); k++) {
                if (p.charAt(k - 1) != '*') {
                    dp[j][k] = dp[j - 1][k - 1] && (p.charAt(k - 1) == '.' || p.charAt(k - 1) == s.charAt(j - 1));
                } else {
                    dp[j][k] = (dp[j - 1][k] && (p.charAt(k - 2) == s.charAt(j - 1) || p.charAt(k - 2) == '.')) || dp[j][k - 2];
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
}
