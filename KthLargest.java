class KthLargest {
    private int k = 0;
    private Queue<Integer> minHeap = null;
    public KthLargest(int k, int[] nums) {
        //minheap and size is k.
        this.minHeap = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) 
            this.add(num);
    }
    
    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else {
            if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(val);
            }
        }
        
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
