class FindStrobogrammatic {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    
    private List<String> helper(int n, int m) {
        if (n == 0)
            return new ArrayList<String>(Arrays.asList(""));
        
        if (n == 1)
            return new ArrayList<String>(Arrays.asList("1", "0", "8"));
        
        List<String> list = helper( n - 2, m);
        List<String> ret = new ArrayList<String>();
        
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (n != m)
                ret.add("0" + s + "0");
            
            ret.add("1" + s + "1");
            ret.add("8" + s + "8");
            ret.add("6" + s + "9");
            ret.add("9" + s + "6");
        }
        
        return ret;
    }
    
}
