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

//From G for G
//use stack, if current val  is less than the top element in the stack, need to do the poll operation to output the largest value
//For every bar ‘x’, we calculate the area with ‘x’ as the smallest bar in the rectangle. 
//If we calculate such area for every bar ‘x’ and find the maximum of all areas, our task is done. 
//How to calculate area with ‘x’ as smallest bar? We need to know index of the first smaller (smaller than ‘x’) bar on left of ‘x’ 
//and index of first smaller bar on right of ‘x’. Let us call these indexes as ‘left index’ and ‘right index’ respectively.


/*We traverse all bars from left to right, maintain a stack of bars. Every bar is pushed to stack once. A bar is popped from stack when a bar of smaller height is seen. When a bar is popped, we calculate the area with the popped bar as smallest bar. How do we get left and right indexes of the popped bar – the current index tells us the ‘right index’ and index of previous item in stack is the ‘left index’. Following is the complete algorithm.

1) Create an empty stack.

2) Start from first bar, and do following for every bar ‘hist[i]’ where ‘i’ varies from 0 to n-1.
a) If stack is empty or hist[i] is higher than the bar at top of stack, then push ‘i’ to stack.
b) If this bar is smaller than the top of stack, then keep removing the top of stack while top of the stack is greater. Let the removed bar be hist[tp]. Calculate area of rectangle with hist[tp] as smallest bar. For hist[tp], the ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is ‘i’ (current index).

3) If the stack is not empty, then one by one remove all bars from stack and do step 2.b for every removed bar. */

 


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


//O(n ^ 2)
class Solution {
    public int largestRectangleArea(int[] heights) {
        if ( heights == null || heights.length == 0)
            return 0;
        
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++) {
            
            int curHeight = heights[i];
              
            //find the left boundary
            int left = i - 1;
            int right = i + 1;
            for (; left >= 0; left--) {
                if (heights[left] < curHeight) {
                    break;
                }
            }
            //find the right boundary
            for (; right < heights.length; right++) {
                if (heights[right] < curHeight) {
                    break;
                }
            }
            
            maxArea = Math.max(maxArea, (right - left - 1) * curHeight);
        }
        
        return maxArea;
    }
}
