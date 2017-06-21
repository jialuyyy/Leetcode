//beats 55.03%
public class PermutationDuplicates {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
        
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, new ArrayList<Integer>(), ret, visited);
        return ret;
    }
    
    private void helper(int[] nums, List<Integer> list, List<List<Integer>> ret, boolean[] visited) {
        if (list.size() == nums.length) {
            ret.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            
            list.add(nums[i]);
            visited[i] = true;
            
            helper(nums, list, ret, visited);
            
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
