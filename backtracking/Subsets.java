//beats 30%
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
        
        helper(nums, 0, new ArrayList<Integer>(), ret);
        return ret;
    }
    
    private void helper(int[] nums, int pos, List<Integer> list, List<List<Integer>> ret) {
        ret.add(new ArrayList<Integer>(list));
        
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, i + 1, list, ret);
            list.remove(list.size() - 1);
        }
    }
}
