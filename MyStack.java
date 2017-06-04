/*Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).*/

//thoughts: using two queues to implement the stack
//when doing the pop() and top() operation, add the elements in queue1 to queue2 until there is only one element left in queue1, which is 
//the element we need. To avoid push elements in queue2 back to queue1, every time swap the queue1 and queue2.

//beats 66.81%
//Time Complexity: push(x) -> O(1)
//pop() -> O(n)
//top() -> O(n)
//empty() -> O(1)

public class MyStack {

    /** Initialize your data structure here. */
    private Queue<Integer> q1 = null;
    private Queue<Integer> q2 = null;
    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int val = q1.poll();
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return val;
    }
    
    /** Get the top element. */
    public int top() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int val = q1.peek();
        q2.offer(q1.poll());
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return val;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
