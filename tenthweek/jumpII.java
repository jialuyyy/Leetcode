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
