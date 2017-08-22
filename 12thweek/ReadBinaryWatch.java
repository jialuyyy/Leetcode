class ReadBinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> ret = new ArrayList<String>();
        
        int[] hours = {8, 4, 2, 1};
        int[] minutes = {32, 16, 8, 4, 2, 1};
        
        for (int i = 0; i <= num; i++) {
            List<Integer> hourList = generate(hours, i);
            List<Integer> minList = generate(minutes, num - i);
            
            for (int hour: hourList) {
                if (hour >= 12) {
                    continue;
                }
                
                for (int minute: minList) {
                    if (minute >= 60) {
                        continue;
                    }
                    ret.add(hour + ":" + (minute < 10? "0" + minute: minute));
                }
            }
        }
        
        return ret;
    }
    
    private List<Integer> generate(int[] nums, int count) {
        List<Integer> ret = new ArrayList<Integer>();
        helper(nums, count, 0, 0, ret);
        return ret;
    }
    
    private void helper(int[] nums, int count, int pos, int sum, List<Integer> ret) {
        if (count == 0) {
            ret.add(sum);
            return;
        }
        
        for (int i = pos; i < nums.length; i++) {
            helper(nums, count - 1, i + 1, sum + nums[i], ret);
        }
    }
    
}
