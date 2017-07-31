//naive n^2 solution
//get the presum from the original array
//two layers loop to get all the subsum from index i to j
// for instance presum[1] - presum[0] = subSum[0,0]
//time limit exception, need to do optimization to make it O(n(log(n)))
public class CountRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null) {
            return 0;
        }
        
        //calculate presum, allocate one more space for the presum array for convenience
        long[] presum = new long[nums.length + 1];
        presum[0] = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            presum[i + 1] = sum;
        }
        
        int count = 0;
        for (int i = 0; i < presum.length - 1; i++) {
            for (int j = i + 1; j < presum.length; j++) {
                
                long val = presum[j] - presum[i];
                if (val >= lower && val <= upper) {
                    count++;
                }
            }
        }
        
        return count;
        
        
    }
}

//merge sort
//[-2, 5, -1]
//presum[0, -2, 3, 2]

//for every presum[j], need to find   lower <= presum[j] - presum[i] <= upper (j > i),
//for every presum[j], we need to let the previous presum[i] to be sorted

public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null) {
            return 0;
        }
        
        //calculate presum, allocate one more space for the presum array for convenience
        long[] presum = new long[nums.length + 1];
        presum[0] = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            presum[i + 1] = sum;
        }
        long[] cache = new long[nums.length + 1];
        return mergeSort(presum, cache, 0, nums.length, lower, upper);
    
    }
    
    private int mergeSort(long[] nums, long[] cache, int start, int end, int lower, int upper) {
        if (start >= end) {
            return 0;
        }
        
        int mid = start + (end - start) / 2;
        
        int leftCount = mergeSort(nums, cache, start, mid, lower, upper);
        int rightCount = mergeSort(nums, cache, mid + 1, end, lower, upper);
        
        int count = leftCount + rightCount;
        
        int low = mid + 1;
        int high = mid + 1;
        int index = start;
        int right = mid + 1;
        
        for (int left = start; left <= mid; left++) {
            while (low <= end && nums[low] - nums[left] < lower) {
                low++;
            }
            
            while (high <= end && nums[high] - nums[left] <= upper) {
                high++;
            }
            
            while (right <= end && nums[right] < nums[left]) {
                cache[index++] = nums[right++];
            }
            
            cache[index++] = nums[left];
            
            count += high - low;
        }
        
        while (right <= end) {
            cache[index++] = nums[right++];
        }
        
        for (int i = start; i<= end; i++) {
            nums[i] = cache[i];
        }
        
        return count;
    }
}
