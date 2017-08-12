public class FrogJump {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return true;
        }
        
        int n = stones.length;
        if (n == 1 || (n == 2 && stones[1] == 1)) {
            return true;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < stones.length; i++) {
            
            if (i > 0 && stones[i] > stones[i - 1] + i) {
                return false;
            }
            
            set.add(stones[i]);
        }
        
        return canReach(set, 1, 1, stones[n - 1]);
    }
    
    private boolean canReach(Set<Integer> set, int cur, int jump, int last) {
        if (last >= cur + jump - 1 && last <= cur + jump + 1) {
            return true;
        }
        
        return set.contains(cur + jump + 1) && canReach(set, cur + jump + 1, jump + 1, last) ||
               set.contains(cur + jump) && canReach(set, cur + jump, jump, last) ||
               jump > 1 && set.contains(cur + jump - 1) && canReach(set, cur + jump - 1, jump - 1, last);
    }
}
