//dp[i] = Math.min(dp[i - j * j] + 1)  j from 1 to j * j <= i, dp[i] denotes the least number of perfect sqaure number which sum //to i  
//dp[0] = 0; as for dp[4], the answer should be 1, and dp[4 - 4] + 1 = 1, so dp[0] = 0
//Time Complexity: O(n ^ 2)
//return dp[n]
public class PerfectSquare {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j] + 1);
            }
            
            dp[i] = min;
        }
        
        return dp[n];
    }
}
