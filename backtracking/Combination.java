public class Combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (n == 0 || k == 0) {
            return ret;
        }
        
        helper(new ArrayList<Integer>(), n, k, 1, ret);
        return ret;
    }
    
    private void helper(List<Integer> list, int n, int k, int pos, List<List<Integer>> ret) {
        if (list.size() == k) {
            ret.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = pos; i <= n; i++) {
            list.add(i);
            helper(list, n, k, i + 1, ret);
            list.remove(list.size() - 1);
        }
    }
}
