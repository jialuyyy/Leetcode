//Time Complexity: O(log(n))
//two passes: first pass find the start position of the range and the second pass find the end position of the range
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        int[] ret = new int[2];
        while (start + 1 < end) {
            int mid = (start + end) >>> 1;
            
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (nums[start] == target) {
            ret[0] = start;
        }
        
        else if (nums[end] == target) {
            ret[0] = end;
        } else {
            return new int[]{-1, -1};
        }
        
        
        start = 0;
        end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = (start + end) >>> 1;
            
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        
        if (nums[end] == target) {
            ret[1] = end;
        }
        
        else if (nums[start] == target) {
            ret[1] = start;
        } else {
            return new int[]{-1, -1};
        }
        
        return ret;
    }
}

// one pass recursion solution
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        
        int[] ret = {nums.length, -1};
        helper(nums, 0, nums.length - 1, target, ret);
        
        return ret[0] <= ret[1] ? ret: new int[]{-1, -1};
    }
    
    private void helper(int[] nums, int start, int end, int target, int[] ret) {
        if (start > end) {
            return;
        }
        
        int mid = (start + end) >>> 1;
        
        if (nums[mid] > target) {
            helper(nums, start, mid - 1, target, ret);
        } else if (nums[mid] < target) {
            helper(nums, mid + 1, end, target, ret);
        } else {
            if (ret[0] > mid) {
                ret[0] = mid;
                helper(nums, start, mid - 1, target, ret);
            }
            
            if (ret[1] < mid) {
                ret[1] = mid;
                helper(nums, mid + 1, end, target, ret);
            }
        }
    }
}
