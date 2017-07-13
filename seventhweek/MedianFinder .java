//maxHeap to maintain the smaller half of the values
//minHeap to maintian the larger half of the values
//every time push the value to the maxHeap first, and poll the maxValue of teh maxHeap to the minHeap, if the minHeap.size() > maxHeap.size()
//poll the minVlue of teh minHeap to the maxHeap, so that we ensure that the size of the maxHeap is larger thatn minHeap by 1 or equal
//addNum(int num): O(1)
//findMedian(): O(1)
public class MedianFinder {

    /** initialize your data structure here. */
    //MaxHeap
    Queue<Integer> maxHeap = null;
    Queue<Integer> minHeap = null;
    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(100, Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        return (maxHeap.size() + minHeap.size()) % 2 == 0? (maxHeap.peek() + minHeap.peek()) / 2.0 : (double) maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
