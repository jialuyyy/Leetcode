//Beats: 59.53%
//iterate the whole array, every time check whether target - nums[i] is in the map, if it is, the target pair is found, if not, put the current 
//value and its index into the hashMap.
//Time Complexity: O(n)
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }
        int[] ret = new int[2];
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(target - nums[i]) != null) {
                ret[0] = hashMap.get(target - nums[i]);
                ret[1] = i;
            } else {
                hashMap.put(nums[i], i);
            }
        }
        
        return ret;
    }
}
