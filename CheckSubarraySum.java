class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return false;
        
        Map<Integer, Integer> presum = new HashMap<>();
        
        presum.put(0, -1);
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (k != 0)
                sum = sum % k;
            
            if (presum.containsKey(sum)) {
                if (i - presum.get(sum) > 1)
                    return true;
            } else {
                presum.put(sum, i);
            }
        }
        
        return false;
        
        
       
    }
}

//O(n ^ 2)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return false;
  
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                
                if (k == 0) {
                    if (sum == 0)
                        return true;
                    else
                        continue;
                }
                if (sum % k == 0)
                    return true;
            }
        }
        
        return false;
    }
}
