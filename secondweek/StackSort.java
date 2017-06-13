//O(n)
public class StackSort {
    public static Deque<Integer> stackSort(Deque<Integer> deque) {
    	Deque<Integer> stack = new ArrayDeque<Integer>();
    	
    	while (!deque.isEmpty()) {
    		int cur = deque.poll();
    		
    		while(!stack.isEmpty() && stack.peek() > cur) {
    			deque.push(stack.pop());
    		}
    		
    		stack.push(cur);
    	}
    	
    	return stack;
    }
    
    public static void main(String[] args) {
    	Deque<Integer> deque = new ArrayDeque<Integer>();
    	deque.push(2);
    	deque.push(5);
    	deque.push(4);
    	deque.push(1);
    	
    	stackSort(deque);
      
    }
}
