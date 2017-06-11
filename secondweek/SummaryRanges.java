//beats 65.45%
//Time Complexity: O(n)
//use two pointers: start and end to iterate over the numbers
//if (num[i] == num[i - 1] + 1), update the end to the current element
//else, add the new string created from the start point and end point to the result and update both the start and 
//end element to the current element.
//don't forget to add the last string to the result list.

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
        
        int start = nums[0];
        int end = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                end = nums[i];
            } else {
                if (start == end) {
                    ret.add(String.valueOf(start));
                } else {
                    ret.add(start + "->" + end);
                }
                start = nums[i];
                end = nums[i];
            }
        }
        
        if (start == end) {
            ret.add(String.valueOf(start));
        } else {
            ret.add(start + "->" + end);
        }
        
        return ret;
    }
}


//beats: 65.45%
//more concise solution reading from leetcode discussion
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
        
        
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            while (i + 1 < nums.length && nums[i] == nums[i + 1] - 1) {
                i++;
            } 
            if (cur == nums[i]) {
                ret.add(cur + "");
            } else {
                ret.add(cur + "->" + nums[i]);
            }
               
        }
       
        
        return ret;
    }
}
