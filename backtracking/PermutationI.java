//beats 58%

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
