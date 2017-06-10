//Space Complexity: O(n)
//Time Complexity: O(n)
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        Deque<Character> stack = new ArrayDeque<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                
                char ch = stack.peek();
                if (c == ']' && ch == '[' || c == ')' && ch == '(' || c == '}' && ch == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
