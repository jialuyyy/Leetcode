//beats:16.20%
/*special case: Input:
[-2147483648,2147483647]
-2147483648
2147483647
Output:
[]
Expected:
["-2147483647->2147483646"]*/
//need to use long to store the difference to avoid overflow
//Time Complexity: O(n)
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ret = new ArrayList<String>();
        if (nums == null) {
            return ret;
        }
        
        if (nums.length == 0) {
            if (upper == lower) {
                ret.add(lower + "");
            } else {
                ret.add(lower + "->" + upper);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            
            if (i == 0) {
                if (nums[i] > lower) {
                    if (nums[i] - 1 == lower) {
                        ret.add(lower + "");
                    } else {
                        ret.add(lower + "->" + (nums[i] - 1));
                    } 
                }
            }
            
            
            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                i++;
            }
            
            
            if (i == nums.length - 1) {
                if (upper > nums[i]) {
                    if (upper - 1 == nums[i]) {
                        ret.add(upper + "");
                    } else {
                        ret.add((nums[i] + 1) + "->" + upper);
                    }
                }
            }
            
            if (i + 1 < nums.length) {
                long tmp = (long)nums[i + 1] - (long)nums[i];
                if (tmp == 2) {
                    ret.add((nums[i] + 1) + "");
                } else if (tmp > 2){
                    ret.add((nums[i] + 1) + "->" + (nums[i + 1] - 1));
                }
            }
        }
        
        return ret;
    }
}
