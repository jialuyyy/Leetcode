//dp[i][j] denotes from index i - 1 to index j - 1, at most how many characters can 
//form a palindrome

class IsValidPalindrome {
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        //d denotes the distance between the start and end character
        for (int d = 0; d < n; d++) {
            for (int i = 1; i <= n - d; i++) {
                int j = i + d;
                
                //the start and the begining character are the same
                if (i == j)
                    dp[i][j] = 1;
                
                else if (s.charAt(i - 1) == s.charAt(j - 1))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        
        return n - dp[1][n] <= k;
    }
}
