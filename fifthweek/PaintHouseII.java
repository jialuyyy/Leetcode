//primitive solution, the same idea as paint house I, but the time Complexity will be O(n * K * K)
//there should be some way to optimize it to be O(n * K)

public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        int houseNumber = costs.length;
        int colorNumber = costs[0].length;
        
        for (int i = 1; i < houseNumber; i++) {
            for (int j = 0; j < colorNumber; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < colorNumber; k++) {
                    if (k == j) {
                        continue;
                    }
                    if (min > costs[i - 1][k]) {
                        min = costs[i - 1][k];
                    }
                }
                
                
                
                costs[i][j] += min;
            }
        }
        
        
        int ret = costs[houseNumber - 1][0];
        
        for (int i = 1; i < colorNumber; i++) {
            ret = Math.min(ret, costs[houseNumber - 1][i]);
        }
        
        return ret;
    }
}
