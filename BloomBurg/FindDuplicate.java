//initial sort is to count the numbers and find the duplicates, but it needs extra space, two passes

// 0 1 2 3 4 5 6 7 8 9
// 1 1 1 1 2 1 1 1 1 1 

//arr[nums[i] - 1]++;


//use binary search 

//Time Complexity O(nlog(n))
public class Solution {
    //1,2,3,4,5,5,6,7,8,9,10
    //nums.length = 11;
    //left = 1;
    // right = 10
    //mid = 5
    //count = 6
    //so the duplicate number is in 1 to 5
    //right = mid;
    
    //mid = 3
    //count = 3
    
    //left = 4
    //mid = 4
    
    //left = 5
    //left = right
    //stop
    
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int left = 1;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            int count = count(nums, mid);
            
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private int count(int[] nums, int mid) {
        int count = 0;
        for (int num: nums) {
            if (num <= mid) {
                count++;
            }
        }
        
        return count;
    }
}
