class MovingAverage {

    /** Initialize your data structure here. */
    private int windowSum = 0;
    private int count = 0;
    private Deque<Integer> queue = null;
    private int size = 0;
    public MovingAverage(int size) {
        this.queue = new ArrayDeque<>();
        this.size = size;
    }
    
    public double next(int val) {
        count++;
        queue.offer(val);
        int tail = count > this.size ? queue.poll() : 0;
        windowSum = windowSum - tail + val;
        
        return windowSum * 1.0 / Math.min(size, count);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
