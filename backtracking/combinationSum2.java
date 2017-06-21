public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i > 0 && candidates[i] == candidates[i - 1] && i != pos) {
                continue;
            }
            
            list.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, list, ret);
            list.remove(list.size() - 1);
        }
    }
}
