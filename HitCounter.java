class HitCounter {

    /** Initialize your data structure here. */
    private int[] time;
    private int[] buckets;
    public HitCounter() {
        time = new int[300];
        buckets = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        
        //the original index is 300, 600 ago, reset to 1
        if (time[index] != timestamp) {
            time[index] = timestamp;
            buckets[index] = 1;
        } else {
            //increase the hit number for the same timestamp
            buckets[index]++;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        //loop over the 300 buckets
        int total = 0;
        for (int i = 0; i < 300; i++) {
            //within the range of the recent 300 seconds
            if (timestamp - time[i] < 300) {
                total += buckets[i];
            }
        }
        
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
