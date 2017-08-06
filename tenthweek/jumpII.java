//am not able to pass the last case TLE
public class jumpII {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j]  + j >= i) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        
        return dp[nums.length - 1];
    }
}


//prune the starting points that are not able to reach the destination to reduce time complexity
//find the first point that nums[j] + j >= i as the starting point for every i afterwards
public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        dp[0] = 0;
        int curIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = curIndex; j < i; j++) {
                if (nums[j]  + j >= i) {
                    dp[i] = dp[j] + 1;
                    curIndex = j;
                    break;
                }
            }
        }
        
        return dp[nums.length - 1];
    }
}
