//two dimensional dp solution
//dp[i][j] denotes the longest common subsequence ending with position i in string A and position j in String B
//if A.charAt(i - 1) == B.charAt(j - 1), dp[i][j] = dp[i - 1][j - 1] + 1
//else dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j])

//the final result should be dp[A.length()][B.length()]
//Time Complexity: O(n ^ 2)
public class LongestCommonSubsequence {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]);
                }
            }
        }
        
        return dp[A.length()][B.length()];
    }
}
