//beats 76.08%
//O(log(n))
//the rotated sorted array is the combination of two ascending arrays. The mid value is possibly in either of the two arrays
//we can throw away almost half numbers of values every time.

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = (start + end) >>> 1;
            
            if (nums[mid] > nums[start]) {
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target <= nums[end] && target >= nums[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        
        if (nums[start] == target) {
            return start;
        }
        
        if (nums[end] == target) {
            return end;
        }
        
        return -1;
    }
}
