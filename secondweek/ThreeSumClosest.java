//beats: 94.09%
//outer loop: iterate over the whole array
//inner loop: two pointers, one starts from the element behind i and the other one starts from the last element and they move towards
//each other based on the comparison between the sum and the target
//Time Complexity: O(n ^ 2)
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return Integer.MIN_VALUE;
        }
        
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int difference = Math.abs(res - target);
        int i = 0;
        
        for (; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int j = i + 1;
            int k = nums.length - 1;
            
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < difference) {
                    difference = Math.abs(target - sum);
                    res = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        
        return res;
    }
}
