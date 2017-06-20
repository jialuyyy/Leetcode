//dp solution, for each number n, it must be the sum of some number i - j * j and a perfect square number j * j, so we just need to know
//the value of dp[i - j * j] and plus 1 should be one of the answer and the minimum value will be the final answer.
//beats 88%
public class PerfectSquare {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            int tmp = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                tmp = Math.min(tmp, dp[i - j * j] + 1);
            }
            
            dp[i] = tmp;
        }
        
        return dp[n];
    }
}
