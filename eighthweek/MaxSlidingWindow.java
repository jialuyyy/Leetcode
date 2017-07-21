//use deque
//for the element that is out of the window boundary, poll it out from the fron of the deque
//for the element that is less than the current value, poll it out from the end

//push the index into the deque
// [i - k + 1, i] for current i, these will be the elements in the window.
// if the element at the front of the deque less than i - k + 1, it is out of boundary
//always peek the front element in the queue as the maximum
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int[] ret = new int[nums.length - k + 1];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            //out of boundary, poll element out
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            //poll the last element out of the queue if it is less than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            
            if (i >= k - 1) {
                ret[count++] = nums[deque.peekFirst()];
            }
            
            
        }
        
        return ret;
    }
}
