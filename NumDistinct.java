//S: [acdabefbc] and T: [ab]
/*first we check with a:

           *  *
      S = [acdabefbc]
mem[1] = [0111222222]
then we check with ab:

               *  * ]
      S = [acdabefbc]
mem[1] = [0111222222]
mem[2] = [0000022244]
*/

class NumDistinct {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        
        for (int i = 0; i <= s.length(); i++)
            dp[0][i] = 1;
        
        for (int i = 1; i <= t.length(); i++)
            dp[i][0] = 0;
        
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1]; 
                } else {
                    dp[i][j] = dp[i][j - 1]; 
                }
            }
        }
        
        return dp[t.length()][s.length()];
    }
}
