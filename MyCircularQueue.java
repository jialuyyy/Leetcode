class MyCircularQueue {

    /** Initialize your data structure here. Set the size of the queue to be k. */
    private int[] queue = null;
    private int headIndex = 0;
    private int count = 0;
    private int capacity = 0;
    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.headIndex = 0;
        this.count = 0;
        this.capacity = k;
        
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (this.count == queue.length)
            return false;
            
        queue[(this.headIndex + this.count) % this.capacity] = value;
        count++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (this.count == 0)
            return false;
        this.headIndex = (this.headIndex + 1) % this.capacity;
        this.count--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (this.count == 0)
            return -1;
        return queue[this.headIndex];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (this.count == 0)
            return -1;
        
        int rearIndex = (this.headIndex + count - 1) % this.capacity;
        return queue[rearIndex];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.count == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return this.count == this.capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

class MyCircularQueue {
    
    private int[] data;
    private int head;
    private int tail;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull() == true) {
            return false;
        }
        if (isEmpty() == true) {
            head = 0;
        }
        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return ((tail + 1) % size) == head;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
