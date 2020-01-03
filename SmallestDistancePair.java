class SmallestDistancePair {
    
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int low = nums[1] - nums[0];
        for (int i = 1; i < n - 1; i++)
            low = Math.min(low, nums[i + 1] - nums[i]);
        
        int high = nums[n - 1] - nums[0];
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (countPairs(nums, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
    
    private int countPairs(int[] nums, int mid) {
        int n = nums.length;
        int res = 0;
        
        for (int i = 0; i < n; i++) {
            int j = i;
            
            while (j < n && nums[j] - nums[i] <= mid)
                j++;
            
            
            res += j - i - 1;
        }
        
        return res;
    }
}
