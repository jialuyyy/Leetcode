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


//optimized solution: two for loops 
//Time Complexity: O(n ^ 2)

public class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        int houseNumber = costs.length;
        int colorNumber = costs[0].length;
        
        int min1 = -1;
        int min2 = -1;
        
        for (int i = 0; i < houseNumber; i++) {
            //keep the last 1st and 2nd minimum elements' index
            int lastMin1 = min1;
            int lastMin2 = min2;
                
            min1 = -1;
            min2 = -1;
            
            for (int j = 0; j < colorNumber; j++) {
                if (j != lastMin1) {
                    costs[i][j] += lastMin1 < 0 ? 0 : costs[i - 1][lastMin1];
                } else {
                    costs[i][j] += lastMin2 < 0 ? 0 : costs[i - 1][lastMin2];
                }
                
                //update the index of the 1st and 2nd minimum elements
                if (min1 < 0 || costs[i][j] < costs[i][min1]) {
                    min2 = min1; 
                    min1 = j;
                } else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }
        }
        
        
        return costs[costs.length - 1][min1];
    }
}
