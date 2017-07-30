//naive n^2 solution
//get the presum from the original array
//two layers loop to get all the subsum from index i to j
// for instance presum[1] - presum[0] = subSum[0,0]
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
