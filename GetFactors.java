class GetFactors {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new ArrayList<>();
        if (n <= 2)
            return ret;
        helper(new ArrayList<>(), ret, n, 2);
        
        return ret;
    }
    
    private void helper(List<Integer> list, List<List<Integer>> ret, int n, int multiply) {
        if (n <= 1) {
            //  4 => {4} this should not be added to the results
            if (list.size() > 1) {
                ret.add(new ArrayList<Integer>(list));
                return;
            }
            
        }
        
        
        
        for (int i = multiply; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                helper(list, ret, n / i, i);
                list.remove(list.size() - 1);
            }
        }
    }
}
