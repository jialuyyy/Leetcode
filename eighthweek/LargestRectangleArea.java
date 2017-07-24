public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int max = Integer.MIN_VALUE;
        int i = 0;
        int minHeight = Integer.MAX_VALUE;
        for (; i < heights.length; i++) {
            if (stack.isEmpty()) {
                stack.offer(i);
            } else {
                if (heights[stack.peekLast()] > heights[i]) {
                    minHeight = Integer.MAX_VALUE;
                    for (int j = stack.peekLast(); j >= 0; j--) {
                        if (heights[j] < minHeight) {
                            minHeight = heights[j];
                        }
        
                        max = Math.max((i - j) * minHeight , max);
                    }
                    
                    while (!stack.isEmpty()) {
                        int p = stack.poll();
                    }
                } 
                stack.offer(i);
                
            }
        }
        
        minHeight = Integer.MAX_VALUE;
        for (int j = heights.length - 1 ; j >= 0; j--) {
            if (heights[j] < minHeight) {
                minHeight = heights[j];
            }
            
            
             max = Math.max((i - j) * minHeight , max);
        }
       
           
        
        
        return max;
    }
}

//use stack, if current val  is less than the top element in the stack, need to do the poll operation to output the largest value

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int max = 0;
        
        
        for (int i = 0; i <= heights.length; i++) {
            
            int cur = i == heights.length ? 0: heights[i];
               
            
            
            while (!stack.isEmpty() && cur < heights[stack.peekFirst()]) {
                
                int minHeight = heights[stack.pollFirst()];
                int leftBound = stack.isEmpty()? 0: stack.peekFirst() + 1;
                
        
                max = Math.max((i - leftBound) * minHeight , max);
                    
            }
            

            stack.offerFirst(i);
        }
        
        
        
        return max;
    }
}
