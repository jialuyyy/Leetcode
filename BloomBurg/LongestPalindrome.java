//from one point expanding to the left and right sides.
public class LongestPalindrome {
    private int maxLen = Integer.MIN_VALUE;
    private int start = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        if (s.length() < 2) {
            return s;
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            expandPalindrome(s, i, i); //odd
            expandPalindrome(s, i, i+1); //even
        }
        
        return s.substring(start, maxLen + start);
    }
    
    private void expandPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        
        if (maxLen < j - i - 1) {
            maxLen = j - i - 1;
            start = i + 1;
        }
    }
}

//dynamic programming
//o(n^2)
class LongestPalindrome {
    private int start = 0;
    private int maxLen = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        
        int n = s.length();
        String res = null;
        
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                
                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        
        return res;
        
    }
    
  
}
