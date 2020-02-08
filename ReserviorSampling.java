class Solution {
    
    int[] nums = null;
    Random rand = null;
    public ReserviorSampling(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        int count = 0;
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            
            if (nums[i] == target) {
                if (rand.nextInt(++count) == 0)
                    result = i;
            }
        }
        
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
