class TopVotedCandidate {
    private int[] persons;
    private int[] times;
    private Map<Integer, Integer> map = new HashMap<>();
    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        
        
        int lead = -1;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < persons.length; i++) {
            count.put(persons[i], count.getOrDefault(persons[i], 0) + 1);
            if (i == 0 || count.get(persons[i]) >= count.get(lead)) {
                lead = persons[i];
            }
            //precompute the lead for each time 
            map.put(times[i], lead); 
        }
    }
    
    public int q(int t) {
        int index = binarySearchFind(this.times, t);
        return map.get(times[index]);
    }
    
    private int binarySearchFind(int[] times, int t) {
        int start = 0;
        int end = times.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (t < times[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        return t < times[end] ? start : end;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
