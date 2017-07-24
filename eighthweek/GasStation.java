public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) {
            return -1;
        }
        
        int index = -1;
        int total = 0;
        int sum = 0;
        
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] -cost[i];
            total += gas[i] - cost[i];
            
            if (sum < 0) {
                index = i;
                sum = 0;
            }
        }
        
        return total < 0 ? -1 : index + 1;
    }
}
