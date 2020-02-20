class ShuffleArray {
    
    int[] nums = null;
    Random r = null;
    public Solution(int[] nums) {
        this.nums = nums;
        r = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null)
            return null;
        
        int[] a = this.nums.clone();
        
        for (int i = 1; i < nums.length; i++) {
            int j = r.nextInt(i + 1);
            swap(a, i, j);
        }
        
        return a;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
