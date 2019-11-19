//[1,2,1,2,6,7,5,1], 2


//w   [3,3,3,8,13,12,6]
//left[0,0,0,3,4,4,4]
//right[4,4,4,4,4,5,6]
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int K) {
        int[] w = new int[nums.length - K + 1];
        
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= K)
                sum -= nums[i - K];
            if (i >= K - 1)
                w[i - K + 1] = sum;
        }
        
        int[] left = new int[w.length];
        int best = 0;
        for (int i = 0; i < w.length; i++) {
            if (w[i] > w[best])
                best = i;
            left[i] = best;
        }
        
        int[] right = new int[w.length];
        best = w.length - 1;
        for (int i = w.length - 1; i >= 0; i--) {
            if (w[i] >= w[best])
                best = i;
            right[i] = best;
        }
        
        int[] ans = new int[]{-1,-1,-1};
        for (int j = K; j < w.length - K; j++) {
            int i = left[j - K];
            int k = right[j + K];
            
            if (ans[0] == -1 || w[i] + w[j] + w[k] > w[ans[0]] + w[ans[1]] + w[ans[2]]) {
                ans[0] = i;
                ans[1] = j;
                ans[2] = k;
            }
        }
        
        return ans;
    }
}
