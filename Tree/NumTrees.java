//dp[i] denotes the number of the binary search trees that the nodes are from 1 to n
//dp[0] = 1;
// dp[1] = 1;

/*
 dp[2] = dp[0]* dp[1] + dp[1] * dp[0];
 
 2    1
1      2
*/
public class NumTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
               dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        
        return dp[n];
    }
}
