//beats 58%
//Time Complexity: O(n! * n)
public class PermutationI {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
        
        helper(nums, new ArrayList<Integer>(), ret);
        return ret;
    }
    
    private void helper(int[] nums, List<Integer> list, List<List<Integer>> ret) {
        if (list.size() == nums.length) {
            ret.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                helper(nums, list, ret);
                list.remove(list.size() - 1);
            }
        }
    }
}

/*
                         1
                 12            21
            312 132 123   321 231 213

Time Complexity : O(n! * n)

*/
class PermutationBFSSolution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        ret.add(ans);
        
        //i is from nums[0] to nums[nums.length - 1]
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            //iterate over the position to insert the new element
            for (int j = 0; j <= i; j++) {
                //iterate over the current result list
                for (int k = 0; k < ret.size(); k++) {
                    List<Integer> temp = new ArrayList<Integer>(ret.get(k));
                    temp.add(j, nums[i]);
                    tmp.add(temp);
                }
            }
            
            ret = tmp;
        }
        
        return ret;
    }
}
