class IsHappy {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        int ret = 0;
        int num = n;
        while(ret != 1) {
            //19
            ret = 0;
            while(num != 0) {
                ret += (num % 10) * (num % 10);
                num = num / 10;
            }
            
            if (set.contains(ret)) {
                return false;
            }
            set.add(ret);
            num = ret;
        }
        
        return true;
        
    }
}
