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
