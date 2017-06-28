//beats 69.13
//two pointers
//if not 0, set the elment at i to be element at j and increase both pointers
//else, increase j
//set all the remaining elements to be zero.
//Time Complexity: O(n)
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int i = 0;
        int j = 0;
        
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i++] = nums[j++];
            } else {
                j++;
            }
        }
        
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }
}
