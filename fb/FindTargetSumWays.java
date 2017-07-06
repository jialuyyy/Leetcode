//find subsum set combination ways
//the subsum should be (sum(nums) + S) / 2
//use dynamic programming to get the total ways to reach the target subsum.

public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int total = 0;
        for (int num: nums) {
            total += num;
        }
        
        
        return total < S || (total + S) % 2 > 0 ? 0: getResult((total + S) >>> 1, nums);
    }
    
    private int getResult(int s, int[] nums) {
        int[] dp = new int[s + 1]; 
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n]; 
        return dp[s];
    }
    
}
