//beats 19.53%
//three pointers. i starts from the first element; j and k one starts from the element behind i and the other starts from the end
//Time Complexity O(n ^ 2)

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return ret;
        }
        
        Arrays.sort(nums);
        int i = 0;
        
        for (; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    j++;
                    k--;
                    ret.add(list);
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
                
                while (j < k && j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                }
                
                while (j < k && k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                }
            }
        }
        
        return ret;
    }
}


//updated: more concise one
//beats: 61.58%
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return ret;
        }
        
        Arrays.sort(nums);
        int i = 0;
        
        for (; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                    ret.add(list);
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        
        return ret;
    }
}
