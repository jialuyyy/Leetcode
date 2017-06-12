//beats 87.43%
//TIme Complexity: O(n ^ 3)
//based on the two sum solution. three layers loop, the most inner loop is the two sum solution. the outer two layers loop is the regular
//loops.
public class 4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return ret;
        } 
        
        Arrays.sort(nums);
        
        int i = 0;
        for (; i < nums.length - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            for (; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int p = j + 1;
                int q = nums.length - 1;
                
                while (p < q) {
                    int sum = nums[i] + nums[j] + nums[p] + nums[q];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[p]);
                        list.add(nums[q]);
                        ret.add(list);
                        
                        while (p < q && nums[p] == nums[p + 1]) {
                            p++;
                        }
                        
                        while (p < q && nums[q] == nums[q - 1]) {
                            q--;
                        }
                        p++;
                        q--;
                    } else if (sum < target) {
                        p++;
                    } else {
                        q--;
                    }
                }
            }
        }
        
        return ret;
    }
}
