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
