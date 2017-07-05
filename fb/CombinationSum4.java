//dp[target] = sum(dp[target－ nums[i]])
//dp[4] = dp[3] + dp[2] + dp[1]
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        helper(nums, target, dp);
        return dp[target];
    }
    
    private int helper(int[] nums, int target, int[] dp) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                res += helper(nums, target - nums[i], dp);
            }
        }
        
        dp[target] = res;
        
        return res;
    }  
}
