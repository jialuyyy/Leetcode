//[1,1,1]
//presum[0] = 0; presum[1] = 1; presum[2] = 2;presum[3] = 3

//start = 0; end = 1, 2, 3
//sums are 1, 2, 3

//start = 1; end = 2, 3
//sums are 1, 2

//start = 2; end = 3
//sum is 1
class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int[] presum = new int[nums.length + 1];
        presum[0] = 0;
        
        //get the presum from 0 to i and keep them in an array
        for (int i = 1; i <= nums.length; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                int sum = 0;
                sum = presum[end] - presum[start];
                if (sum == k) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
