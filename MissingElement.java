class MissingElement {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        //means k is not in the boundary
        if (k > missing(n - 1, nums))
            return nums[n - 1] + k - missing(n - 1, nums);
        
        int idx = 1;
        
        while (missing(idx, nums) < k)
            idx++;
        
        return nums[idx - 1] + k - missing(idx - 1, nums);
    }
    
    private int missing(int idx, int[] nums) {
        return nums[idx] - nums[0] - idx;
    }
}
