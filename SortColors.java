/*Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.*/

//beats: 61.41%
//Time complexity: O(n)
//use three pointers:
//i is used to mark the end of the 0
//j is used to mark the 1
//k is used to mark the beginning of 2
// if nums[j] == 1, increase the j pointer by 1.
// if nums[j] == 0 , swap the value of index i and j, and increase both of the pointers.
// if nums[j] == 2, swap the value of index j and k, and decrease the pointer k.
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        
        int i = 0;
        int j = 0;
        int k = nums.length - 1;
        
        while (j <= k) {
            if (nums[j] == 1) {
                j++;
            } else if (nums[j] == 0) {
                swap(nums, i, j);
                i++;
                j++;
            } else {
                swap(nums, j, k);
                k--;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
