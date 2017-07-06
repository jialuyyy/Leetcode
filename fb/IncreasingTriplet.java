//dp[i] = max(dp[j]) + 1  j < i && j >= 0 && nums[j] < nums[i]
//if there is no nums[j] < nums[i] before index i, dp[i] = 1;

//Time Complexity: O(n ^ 2)
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length <= 3) {
            return false;
        }
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int curMax = 0;
        for (int i = 1; i < nums.length; i++) {
            curMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    curMax = Math.max(curMax, dp[j]);
                }
            }
            
            dp[i] = curMax + 1;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == 3) {
                return true;
            }
        }
        
        return false;
    }
}
