//beats 28%
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return ret;
        }
        
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<Integer>(), ret);
        
        return ret;
    }
    
    private void helper(int[] candidates, int target, int pos, List<Integer> list, List<List<Integer>> ret) {
        if (target == 0) {
            ret.add(new ArrayList<Integer>(list));
            return;
        }
        
        if (target < 0) {
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(candidates, target - candidates[i], i, list, ret);
            list.remove(list.size() - 1);
        }
    }
}
