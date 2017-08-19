class AndroidUnlockPattern {
    public int numberOfPatterns(int m, int n) {
        
        int res = 0;
        boolean[] visited = new boolean[10];
        int[][] skipTable = new int[10][10];
        
        skipTable[1][3] = skipTable[3][1] = 2;
        skipTable[4][6] = skipTable[6][4] = 5;
        skipTable[7][9] = skipTable[9][7] = 8;
        skipTable[1][7] = skipTable[7][1] = 4;
        skipTable[2][8] = skipTable[8][2] = 5;
        skipTable[3][9] = skipTable[9][3] = 6;
        skipTable[1][9] = skipTable[9][1] = 5;
        skipTable[3][7] = skipTable[7][3] = 5;
        
        //for different length, do dfs from 1-9
        //optimization: symmetric feature
        for (int i = m; i <= n; i++) {
            //first
            /*for (int j = 1; j <= 9; j++) {
                res += dfs(visited, skipTable, j, i - 1);
            }*/
            
            //second 
            res += dfs(visited, skipTable, 1, i - 1) * 4;
            res += dfs(visited, skipTable, 2, i - 1) * 4;
            res += dfs(visited, skipTable, 5, i - 1);
            
        }
        
        return res;
    }
    
    private int dfs(boolean[] visited, int[][] skipTable, int cur, int remains) {
        int res = 0;
        
        if (remains < 0) {
            return 0;
        }
        
        if (remains == 0) {
            return 1;
        }
        
        visited[cur] = true;
        for (int i = 1; i <= 9; i++) {
            if (!visited[i] && (skipTable[cur][i] == 0 || visited[skipTable[cur][i]])) {
                res += dfs(visited, skipTable, i, remains - 1);
            }
        }
        visited[cur] = false;
        
        return res;
    }
}
