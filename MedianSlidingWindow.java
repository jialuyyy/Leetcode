//minHeap: keep values that larger or equals to median
//maxHeap: keep values that smaller than median
//minHeap.size() - maxHeap.size() == 1 so that it will be easy to get the median
class MedianSlidingWindow {
    private Queue<Integer> minHeap = null;
    private Queue<Integer> maxHeap = null;
    public double[] medianSlidingWindow(int[] nums, int k) {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(k, new Comparator<>(){
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        
        double[] ret = new double[nums.length - k + 1];
        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                ret[i - k] = getMedian();
                remove(nums[i - k]);
            } 
            
            if (i < nums.length) { 
                add(nums[i]);
            }
        }
        
        return ret;
    }
    
    private void add(int num) {
        if (num < getMedian()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        
        if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        } 
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    private void remove(int num) {
        if (num < getMedian()) {
            maxHeap.remove(num);
        } else {
            minHeap.remove(num);
        }
        
        if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        } 
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    private double getMedian() {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return 0.0;
        }
        
        if (minHeap.size() == maxHeap.size())
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        
        return (double)minHeap.peek();
            
    }
}
