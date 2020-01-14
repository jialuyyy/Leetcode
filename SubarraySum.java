//time limit exceeds
class subarraySum
{
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                
                if (sum == k)
                    count++;
            }
        }
        
        return count;
    }
}


//[1,1,1]
//presum[0] = 0; presum[1] = 1; presum[2] = 2;presum[3] = 3

//start = 0; end = 1, 2, 3
//sums are 1, 2, 3

//start = 1; end = 2, 3
//sums are 1, 2

//start = 2; end = 3
//sum is 1
//Time Complexity : O(n ^ 2)
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

//use a map to keep the presum and the counting mapping
//check if the map contains currentSum - target every time, if found, which means we get a
//valid the subsum and we can increase the count and update the map every time
//Time Complexity : O(n)
//Space Complexity: O(n)
class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        
        Map<Integer, Integer> sumCounting = new HashMap<>();
        
        //presum equals 0
        sumCounting.put(0, 1);
        
        int sum = 0;
        int count = 0;
        for (int i = 0; i< nums.length; i++) {
            sum += nums[i];
            
            if (sumCounting.containsKey(sum - k)) {
                count += sumCounting.get(sum - k);
            }
            
            sumCounting.put(sum, sumCounting.getOrDefault(sum, 0) + 1);
        }
        
        return count;
        
    }
}
