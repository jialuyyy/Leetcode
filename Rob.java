class Rob {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        if (nums.length < 2) {
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        
        int max = dp[nums.length - 1];
        
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        
        max = Math.max(max, dp[nums.length - 1]);
        
        return max;
    }
}
