//start from the last ballon
//for the last ballon the product is nums[start - 1] * ballon[k] * nums[end + 1]
//for example [4,5,8], if the last ballon is 8 then the product for the last step should be 1 * 8 * 1
//dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + nums[i - 1]*nums[k]* nums[j + 1]) K is from i to j
public class BurstBallon {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        arr[0] = 1;
        arr[arr.length - 1] = 1;
        
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = nums[i];
        }
        
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        
        for (int i = 1; i < dp.length - 1; i++) {
            for (int j = i; j >= 1; j--) {
                
                //from j to i, pick the last ballon to get the max value
                for (int k = j; k <= i; k++) {
                    dp[j][i] = Math.max(dp[j][i], dp[j][k - 1] + dp[k + 1][i] + arr[k] * arr[j - 1] * arr[i + 1]);
                }
            }
        }
        
        return dp[1][dp.length - 2];
    }
}
