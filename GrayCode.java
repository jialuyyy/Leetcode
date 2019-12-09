// 0, 1 -> 00 01 11 10 ->(000,001,011,010 ) (110,111,101,100)



class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        
        ret.add(0);
        
        for (int i = 0; i < n; i++) {
            int size = ret.size();
            
            for (int k = size - 1; k >= 0; k--)
                ret.add(ret.get(k) | 1 << i);
        } 
        
        return ret;
    }
}
