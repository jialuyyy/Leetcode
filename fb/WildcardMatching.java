//dp[i][j] denotes whether substring from 0 to i in s matches substring from 0 to j in p
// if p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?', dp[i][j] = dp[i - 1][j - 1]
// if p.charAt(j - 1) == '*', dp[i][j] = dp[i - 1][j] || dp[i][j - 1], dp[i - 1][j], means '*' matches the character i - 1 in s, and dp[i][j - 1]
//means '*' matches empty
//else dp[i][j] = false
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }   
        
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        
        dp[0][0] = true;
        
        for (int i = 1; i <= pLen; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }
        
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        
        return dp[sLen][pLen];
    }
}
