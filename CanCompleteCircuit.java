class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int cur = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            cur += gas[i] - cost[i];
            
            if (cur < 0) {
                start = i + 1;
                cur = 0;
            }
        }
        
        return total >= 0 ? start : -1;
    }
}
