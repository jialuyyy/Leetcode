//dp[i][j] means the money that gaurantee to win within the range of i to j [i, j] inclusive

public class GetMoneyAmount {
    // the diagonal will always be 0
    //dp[1][1] = 0
    //dp[2][2] = 0
    public int getMoneyAmount(int n) {
        
        int[][] dp = new int[n + 1][n + 1];
        for(int j = 2; j <= n; j++){
            for(int i = j - 1; i > 0; i--){
                int globalMin = Integer.MAX_VALUE;
                for(int k = i + 1; k < j; k++){
                    int localMax = k + Math.max(dp[i][k-1], dp[k+1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                //if dp[2][3] then pick 2
                //always pick the smaller one between the two numbers that the difference is 1
                dp[i][j] = i + 1 == j ? i : globalMin;
            }
        }
        return dp[1][n];
    }
}
