public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
        
        Arrays.sort(nums);
        
        int[] parent = new int[nums.length];
        Arrays.fill(parent, -1);
        int[] dp = new int[nums.length];
        
        dp[0] = 1;
        int maxSize = 1;
        int lastIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                
                if (nums[i] % nums[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
                
            }
            
            if (maxSize < dp[i]) {
                maxSize = dp[i];
                lastIndex = i;
            }
        }
        
        while (lastIndex >= 0) {
            ret.add(0, nums[lastIndex]);
            lastIndex = parent[lastIndex];
        }
        
        return ret;
    }
}
