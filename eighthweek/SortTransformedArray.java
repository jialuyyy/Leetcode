//two situation, a > 0 and a < 0, a==0 can be included in any of the two situations
//if a > 0, the start and the end of the sorted array will be larger than the middle, so fill out the array from the end of the result array
//if a < 0, the start and the end of the sorted array will be smaller than the middle, so fill out the array from the start of the result array.
//stop the while loop until the two pointers meet
//Time Complexity : O(n)

public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        
        int[] ret = new int[nums.length];
        
        int start = 0;
        int end = nums.length - 1;
        if (a >= 0) {
            int count = ret.length - 1;
            while (start <= end) {
                int r1 = a * nums[start] * nums[start] + b * nums[start] + c;
                int r2 = a * nums[end] * nums[end] + b * nums[end] + c;
                if (r1 > r2) {
                    ret[count--] = r1;
                    start++;
                } else {
                    ret[count--] = r2;
                    end--;
                }
            }
        } else {
            int count = 0;
            while (start <= end) {
                int r1 = a * nums[start] * nums[start] + b * nums[start] + c;
                int r2 = a * nums[end] * nums[end] + b * nums[end] + c;
                if (r1 < r2) {
                    ret[count++] = r1;
                    start++;
                } else {
                    ret[count++] = r2;
                    end--;
                }
            }
        }
        
        return ret;
        
    }
}
