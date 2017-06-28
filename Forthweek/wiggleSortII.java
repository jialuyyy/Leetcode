//use extra space and arrays.sort()
//Time Complexity: O(nlog(n))
//Space Complexity: O(n)
//beats 78%, not satisfy the problem requirements
//maintain some pointers, then iterate over the tmp array and put one small, one large element respectively into the original array

public class wiggleSortII {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        Arrays.sort(nums);
        
        int[] numsTmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsTmp[i] = nums[i];
        }
        
        int mid = (0 + nums.length - 1) / 2 + 1;
        
        int i = mid - 1;
        int k = 0;
        int j = nums.length - 1;
        
        while (i >= 0 && j >= mid) {
            nums[k++] = numsTmp[i--];
            nums[k++] = numsTmp[j--];
        }
        
        if (i >= 0) {
            nums[nums.length - 1] = numsTmp[i];
        }
    }
}


/*use three-way partition to sort the array. use quick select first, but some of the test cases are not passed, 
as the duplicates will not be around the median element, we need to ensure the elements are in three parts, larger than median, 
equal to median, less than median*/
//ret[0] points to the start of the pivot element while ret[1] points to the end of the pivot element.
//Time Complexity: O(n)
//Space Complexity: O(n)
//need to do further optimization to make the space complexity to be O(1)
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int median = threeWayPartition(nums, 0, nums.length - 1, nums.length % 2 == 0? nums.length / 2 : nums.length / 2 + 1);
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
        }
        
        int i = median + 1;
        int j = median;
        int k = nums.length - 1;
        
        int index = 0;
        while (j >= 0 && k >= i) {
            nums[index++] = tmp[j--];
            nums[index++] = tmp[k--];
        }
        
        if (j >= 0) {
            nums[nums.length - 1] = tmp[j];
        }
    }
    
    private int threeWayPartition(int[] nums, int start, int end, int k) {
        int[] ret = partition(nums, start, end);
        int lb = ret[0];
        int rb = ret[1];
        if (k - 1 < lb) {
            return threeWayPartition(nums, start, lb - 1, k);
        } else if (k - 1 > rb) {
            return threeWayPartition(nums, rb + 1, end, k);
        } else {
            return k - 1;
        }
    }
    
    //color sort
    private int[] partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start;
        while (i <= end) {
            if (pivot == nums[i]) {
                i++;
            } else if (nums[i] < pivot) {
                swap(nums, i, start);
                i++;
                start++;
            } else {
                swap(nums, i, end);
                end--;
            }
        }
        int[] ret = new int[2];
        ret[0] = start;
        ret[1] = end;
        
        return ret;
    }
    
    private void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }
}
