/*Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.

 Notice

You should do really partition in array nums instead of just counting the numbers of integers smaller than k.

If all elements in nums are smaller than k, then return nums.length*/


//thoughts: two pointers
//one starts from left and the other one starts from the right
//when the current value is less than k, keep moving left pointer and when the current value is larger than or equal to current value
//keep moving the right pointer
//if left < right, swap the two values

/*while (left <= right) instead of while (left < right), as the following special case, the expected result is 12 instead of 11.
array = [7,7,9,8,6,6,8,7,9,8,6,6]
k = 10*/

//Time Complexity: O(n)
//Space Complexity: O(1)


public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if (nums == null) {
	        return -1;
	    }
	    
	    int left = 0;
	    int right = nums.length - 1;
	    
	    while (left <= right) {
	        while (left <= right && nums[left] < k) {
	            left++;
	        }
	        
	        while (left <= right && nums[right] >= k) {
	            right--;
	        }
	        
	        if (left < right) {
	            int tmp = nums[left];
	            nums[left] = nums[right];
	            nums[right] = tmp;
	            left++;
	            right--;
	        }
	    }
	    
	    return left;
    }
}
