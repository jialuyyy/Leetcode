class MaxSubArrayLen {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int[] presum = new int[nums.length + 1];
        
        int maxLen = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
            if (map.containsKey(presum[i] - k))
                maxLen = Math.max(maxLen, i - map.get(presum[i] - k));
            
            if (!map.containsKey(presum[i]))
                map.put(presum[i], i);
            
        }
    
        return maxLen;
    }   
}

class MaxSubArrayLen {
    public int maxSubArrayLen(int[] nums, int k) {
        int[] presum = new int[nums.length + 1];
        
        for (int i = 1; i < nums.length + 1; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        int maxLen = 0;
        for (int i = 0; i < nums.length + 1; i++) {
            for (int j = i + 1; j < nums.length + 1; j++) {
                if (presum[j] - presum[i] == k) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }
    
        return maxLen;
    }   
}
