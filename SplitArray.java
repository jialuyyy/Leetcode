class SplitArray {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int max = 0;
        int sum = 0;
        
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        
        long l = (long)max;
        long r = (long)sum;
        
        while (l <= r) {
            long mid = l + (r - l) / 2;
            
            if (valid(mid, nums, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return (int)l;
        
    }
    
    private boolean valid(long mid, int[] nums, int m) {
        long total = 0;
        //number of subarrays to satisfy the requirement
        int count = 1;
         
        for (int num : nums) {
            total += num;
            
            if (total > mid) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
}
