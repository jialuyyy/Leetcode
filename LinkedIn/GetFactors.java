public class GetFactors {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (n == 0 || n == 1) {
            return ret;
        }
        
        helper(new ArrayList<Integer>(), ret, 2, n);
        return ret;
    }
    
    private void helper(List<Integer> list, List<List<Integer>> ret, int mul, int target) {
        if (1 == target) {
            if (list.size() > 1) {
                ret.add(new ArrayList<Integer>(list));
            }
            return;
        }
        
        for (int i = mul; i <= target; i++) {
            if (target % i == 0) {
                list.add(i);
                helper(list, ret, i, target / i);
                list.remove(list.size() - 1);
            }
        }
    }
}
