//maintain a presum hashmap
//for example [1, -1, 5, -2, 3]
//[1, 0, 5, 3, 6]
//if current sum equals to k, update the max value to i + 1
//else check whether the map contains sum - k, if contains, which means i - map.get(sum - k) is the candidate of maxlen
//put the sum into the map if it is not contains in it, as if exists duplicates, always maintain the most left index in the map to ensure
//the sublength to be the maximum.

//Time Complexity: 49.88%
//Space Complxity: O(n)
public class MaxSubArrayLen {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                max = i + 1;
            } else if (map.containsKey(sum - k)){
                max = Math.max(max, i - map.get(sum - k));
            }
            
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return max;
        
    }
}
