//beats 69%
//Time Compelxity: O(n ^ 2)
//use bottom-up dp, the bottom level's minimum value will be it self and for the upper level's element, the dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1], j + 1) + triangle.get(i).get(j)

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int i = triangle.size() - 1; i >= 0 ; i--) {
            for (int j = i; j >= 0; j--) {
                if (i == triangle.size() - 1) {
                    dp[i][j] = triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }
        } 
        
        return dp[0][0];
    }
}
