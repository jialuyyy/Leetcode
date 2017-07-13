// using queue to cope with this problem
// if current size is less than the given size, push the value into the queue and return the average value directly
// if current size is equal to the given size, poll the value out of the queue first, and deduct this value from the sum, offer the
//new value into the queue and add it to the sum, return the average

public class MovingAverage {

    /** Initialize your data structure here. */
    private Deque<Integer> queue = null;
    private int sum = 0;
    private int size = 0;
    public MovingAverage(int size) {
        queue = new ArrayDeque<Integer>();
        this.size = size;
    }
    
    public double next(int val) {
        if (queue.size() == this.size) {
            int removed = queue.poll();
            sum -= removed;
        }
        
        queue.offer(val);
        sum += val;
        
        return sum / (queue.size() * 1.0);
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
