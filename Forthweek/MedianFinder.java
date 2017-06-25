//use a minHeap and a maxHeap
//push the element into the maxHeap
//1. if the maxHeap.size() - minHeap.size() >= 2, push the maxheap's head element into the minheap
//2. if the minheap has element and the head element of the maxHeap is larger than the head element of minHeap, exchange the two element
//Time Complexity: AddNum -> O(log(n))
//findMedian -> O(1)
public class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> minHeap = null;
    PriorityQueue<Integer> maxHeap = null;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        if (maxHeap.size() - minHeap.size() >= 2) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() != 0 && maxHeap.peek() > minHeap.peek()) {
            int tmp1 = maxHeap.poll();
            int tmp2 = minHeap.poll();
            maxHeap.offer(tmp2);
            minHeap.offer(tmp1);
        }
    }
    
    public double findMedian() {
        int sizeMin = minHeap.size();
        int sizeMax = maxHeap.size();
        int total = sizeMin + sizeMax;
        if (total % 2 == 1) {
            return (double) maxHeap.peek();
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
