public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret  = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
        
        Arrays.sort(nums);
        helper(nums, new ArrayList<Integer>(), 0, ret);
        return ret;
    }
    
    private void helper(int[] nums, List<Integer> list, int pos, List<List<Integer>> ret) {
        ret.add(new ArrayList<Integer>(list));
        
        for (int i = pos; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && i != pos) {
                continue;
            }
            
            list.add(nums[i]);
            helper(nums, list, i + 1, ret);
            list.remove(list.size() - 1);
            
        }
    }
}
