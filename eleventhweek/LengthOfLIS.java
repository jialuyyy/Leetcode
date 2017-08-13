//Time Complexity: O(n ^ 2)

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        
        int globalMax = 1;
        
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            globalMax = Math.max(globalMax, dp[i]);
        }
        
        return globalMax;
        
        
    }
}


//Time Complexity: O(nlog(n))
//binary search

//10 9 2 5 3 7 101 18

//10
//9
//2
//2 5
//2 3
//2 3 7
//2 3 7 101
//2 3 7 18

//len = 4
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] result = new int[nums.length];
        int len = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int start = 0;
            int end = len;
            
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (result[mid] > nums[i]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            
            int insertAt = 0;
            if (result[start] >= nums[i]) {
                result[start] = nums[i];
                insertAt = start;
            } else {
                result[end] = nums[i];
                insertAt = end;
            }
            
            if (insertAt == len) {
                len++;
            }
        }
        
        return len;
    }
}
