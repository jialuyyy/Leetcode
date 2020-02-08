class MaxStack {

    /** initialize your data structure here. */
    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();
    
    public MaxStack() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack1.push(x);
        
        int tempMax = stack2.isEmpty() ? Integer.MIN_VALUE : stack2.peek();
        tempMax = Math.max(tempMax, x);
        
        stack2.push(tempMax);
        
    }
    
    public int pop() {
        int val = stack1.pop();
        stack2.pop();
        
        return val;
    }
    
    public int top() {
        if (stack1.isEmpty())
            return -1;
        return stack1.peek();
    }
    
    public int peekMax() {
        if (stack2.isEmpty())
            return -1;
        return stack2.peek();
    }
    
    public int popMax() {
        int val = stack2.peek();
        
        Deque<Integer> tempStack = new ArrayDeque<>();
        while (stack1.peek() != val)
        {
            tempStack.push(stack1.pop());
            stack2.pop();
        }        
        
        //locate the max
        stack1.pop();
        stack2.pop();
        
        while (!tempStack.isEmpty()) {
            int x = tempStack.pop();
            stack1.push(x);
        
            int tempMax = stack2.isEmpty() ? Integer.MIN_VALUE : stack2.peek();
            tempMax = Math.max(tempMax, x);
        
            stack2.push(tempMax);
        }
        return val;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
