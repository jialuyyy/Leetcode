//sort the array
//i and j are all at the left side of the whole array, make sure j is always in the front of i
//when absolute diff is less than k, incease j; else, increase i, when equal, increse left.
//Time complexity: O(nlog(n))
public class kthDiffPairs {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int i = 0;
        int j = 1;
        int count = 0;
        
        while (j < nums.length) {
            
            if (i >= j || Math.abs(nums[i] - nums[j]) < k) {
                j++;
            } else if ((i > 0 && nums[i] == nums[i - 1]) || Math.abs(nums[i] - nums[j]) > k) {
                i++;
            } else {
                i++;
                count++;
            }
        }
        
        
        return count;
    }
}

//use a hashmap to avoid sorting
//for the special case k == 0, need to check whether the array contains more than once of the same value
//Time Complexity: O(n)
//Space Complexity : O(n)
public class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k < 0) {
            return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num: nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        
        int count = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (k != 0) {
                if (map.containsKey(entry.getKey() - k)) {
                    count++;
                }
            } else {
                if (entry.getValue() >= 2) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
