//remove duplicates II

//thoughts: two pointers -- one(i) is used to update the array values and another one(j) is used to iterate over the whole array. 
//use a count variable to count the duplicates times, if count equals 2, update pointer j; if count < 2, update the array and increase
//count; if two values are different, reset the count to 1 and update the array.

//time complexity: O(n)
//beats 4.14% of submissions

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return 1;
        }
        
        int i = 0;
        int j = 1;
        int count = 1;
        
        while (j < nums.length) {
            if (nums[i] == nums[j] && count != 2) {
                count++;
                nums[++i] = nums[j++];
            } else if (nums[i] == nums[j]) {
                j++;
            } else {
                count = 1;
                nums[++i] = nums[j++];
            }
        }
        
        return i + 1;
    }
}
