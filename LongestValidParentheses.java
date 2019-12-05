class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int longest = 0;
        
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            
            else {
                if (!stack.isEmpty()) {
                    if (s.charAt(stack.peek()) == '(')
                        stack.pop();
                    else
                        stack.push(i);
                }
                
                else {
                    stack.push(i);
                }
            }
        }
        
        if (stack.isEmpty())
            return n;
        
        int a = n;
        int b = 0;
        
        while (!stack.isEmpty()) {
            b = stack.peek();
            stack.pop();
            longest = Math.max(longest, a - b - 1);
            a = b;
        }
        longest = Math.max(longest, a);
        return longest;
        
    }
}

