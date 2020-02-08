class FindMaxConsecutiveOnesII {
    public int findMaxConsecutiveOnesII(int[] nums) {
        int l = 0;
        int h = 0;
        int zeroCount = 0;
        int max = 0;
        int k = 1;
        for (; h < nums.length; h++) {
            if (nums[h] == 0) {
                zeroCount++;
            }
            
            while (zeroCount > k) {
                if (nums[l++] == 0)
                    zeroCount--;
            }
            
            max = Math.max(max, h - l + 1);
        }
        
        return max;
    }
}
