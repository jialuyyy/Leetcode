//[-2, 0, 1,3], target = 2
//for this problem, sort first, and use three pointers i, j, k, i points the start of the element and j points to the i + 1, while k points
//to the end.
//if nums[i] + nums[j] + nums[k] < target, which means, for current i,j, all the elements from j + 1 to k will satisfy the condition, so
//count += k - j; and increase j
//if nums[i] + nums[j] + nums[k] < target, which means we need to decrease k to let the sum to get smaller
//beats 64%

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        
        Arrays.sort(nums);
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    count += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        
        return count;
    }
}
