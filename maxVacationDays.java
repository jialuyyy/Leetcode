//TLE
class MaxVacationDays {
    private int max = 0;
    private int N = 0;
    private int K = 0;
    
    public int maxVacationDays(int[][] flights, int[][] days) {
        N = flights.length;
        K = days[0].length;
        
        dfs(flights, days, 0, 0, 0);
        return max;
    }
    
    private void dfs(int[][] f, int[][] d, int curr, int week, int sum) {
        if (week == K) {
            max = Math.max(sum, max);
            return;
        }
        
        for (int dest = 0; dest < N; dest++) {
            if (curr == dest || f[curr][dest] == 1)
                dfs(f, d, dest, week + 1, sum + d[dest][week]);
        }
    }
}

class MaxVacationDays {
    private int N = 0;
    private int K = 0;
    
    public int maxVacationDays(int[][] flights, int[][] days) {
        N = flights.length;
        K = days[0].length;
        int[][] memo = new int[N][K];
        return dfs(flights, days, 0, 0, memo);
    }
    
    private int dfs(int[][] f, int[][] d, int curr, int week, int[][] memo) {
        if (week == K) {
            return 0;
        }
        
        if (memo[curr][week] != 0)
            return memo[curr][week];
        int res = 0;
        for (int dest = 0; dest < N; dest++) {
            if (curr == dest || f[curr][dest] == 1) {
                res = Math.max(res, d[dest][week] + dfs(f, d, dest, week + 1, memo));
            }
        }
        
        memo[curr][week] = res;
        
        return res;
    }
}

//use dp, dp[j][i] means on week i and at city j, what is the maximum vacation we should gain
//and get the meaximum from dp[0][0] to dp[N - 1][0], need to consider that if flight[0][i] == 1 at the end
//if not, have to only think about dp[0][0]
class MaxVacationDays {
    
    
    public int maxVacationDays(int[][] flights, int[][] days) {
       int[][] dp = new int[flights.length][days[0].length];
        
        for (int i = days[0].length - 1; i >= 0; i--) {
            for (int j = 0; j < days.length; j++) {
                //week i at city j the max days
                dp[j][i] = days[j][i];
                
                for (int p = 0; p < days.length; p++) {
                    if ((j == p || flights[j][p] == 1) && i < days[0].length - 1) {
                        dp[j][i] = Math.max(dp[j][i], dp[p][i + 1] + days[j][i]);
                    }
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < days.length; i++) {
            if (i == 0 || flights[0][i] == 1)
                res = Math.max(res, dp[i][0]);
        }
        
        return res;
    }
    
    
}
