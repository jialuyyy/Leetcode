//dp[i][j] donotes word1.substring(0, i) to word2.substring(0, j) should be how many minimum steps
//initialization: dp[i][0] = i  dp[0][j] = j;
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        
        if (word1.length() == 0 || word2.length() == 0) {
            return word1.length() == 0? word2.length() : word1.length();
        }
        
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                }
            }
        }
        
        return dp[word1.length()][word2.length()];
    }
}
