public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (k == 0 || n == 0) {
            return ret;
        }
        
        helper(k, n, new ArrayList<Integer>(), ret, 0);
        return ret;
    }
    
    private void helper (int k, int n, List<Integer> list, List<List<Integer>> ret, int pos) {
        if (list.size() == k && n == 0) {
            ret.add(new ArrayList<Integer>(list));
            return;
        }
        
        if (n < 0) {
            return;
        }
        
        for (int i = pos; i < 9; i++) {
            list.add(i + 1);
            helper(k ,n - (i + 1), list, ret, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
