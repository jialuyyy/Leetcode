//beats 47.81%
//15 ms
//time complexity: O(n)

//Remove Duplicates from Sorted Array

//thoughts: two pointers, one(j) is used to iterate over the whole array, another one(i) is used
//update the array if value is different than the current one. return i + 1.

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        if (nums.length == 1) {
            return 1;
        }
        
        int i = 0;
        int j = 1;
        
        while (j < nums.length) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j++];
            } else {
                j++;
            }
        }
        
        return i + 1;
    }
}

//modified: the corner case can be removed
//beats 65.48%
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int i = 0;
        int j = 0;
        
        while (j < nums.length) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j++];
            } else {
                j++;
            }
        }
        
        return i + 1;
    }
}
