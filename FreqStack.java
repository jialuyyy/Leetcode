class FreqStack {
    
    //frequency map
    Map<Integer, Integer> freq = null;
    
    //frequency to stack map
    Map<Integer, Deque<Integer>> freqStackMap = null;
    
    //maxFreq
    int maxFreq = 0;
    public FreqStack() {
        freq = new HashMap<>();
        freqStackMap = new HashMap<>();
    }
    //O(1) for push
    public void push(int x) {
        freq.put(x, freq.getOrDefault(x, 0) + 1);
        int frequency = freq.get(x);
        maxFreq = Math.max(maxFreq, frequency);
        if (freqStackMap.get(frequency) == null)
            freqStackMap.put(frequency, new ArrayDeque<>());
        freqStackMap.get(frequency).push(x); 
    }
    //O(1) for pop
    public int pop() {
        int ret = freqStackMap.get(maxFreq).pop();
        if (freqStackMap.get(maxFreq).size() == 0) {
            freqStackMap.remove(maxFreq);
            maxFreq--;
        }
        freq.put(ret, freq.get(ret) - 1);
        return ret;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
