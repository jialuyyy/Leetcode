//beats 41.32%
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = (start + end) >>> 1;
            
            if (nums[mid] < nums[mid - 1]) {
                end = mid;
            } else if (nums[mid] > nums[mid - 1]) {
                start = mid;
            }
        }
        
        return nums[start] > nums[end] ? start : end;
    }
}
