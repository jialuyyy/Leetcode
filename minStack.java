/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.*/


//beats 26.90%
//maintain two stacks -- one is normal, another one is used to maintain the minimum values, when it is empty or its top value is larger than
//or equal to the new element, push the new element into the min stack. the equal value needs to be pushed into the min stack, as 
//this means we have more than one minimum values, etc(0,1,-1,-1), the -1 appears twice, after poping the first -1 out from the stack, the minimum
//value is still -1, so both -1 should be pushed into the min stack.

//Time Complexity: push -> O(1)
//Time Complexity: pop -> O(1)
//Time Complexity: top -> O(1)
//Time Complexity: getMin -> O(1)

public class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack = null;
    Stack<Integer> min = null;
    public MinStack() {
        stack = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }
    }
    
    public void pop() {
        int x = stack.pop();
        if (min.peek() == x) {
            min.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
