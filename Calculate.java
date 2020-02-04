class Calculate {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int result = 0;
        int number = 0;
        int sign = 1;
        
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                number = 10 * number + (int)(c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                
                //reset to calculate the stuff in the parenthesis
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                
                result *= stack.pop();
                result += stack.pop();
            }
        }
        
        if (number != 0)
            result += number * sign;
        
        return result;
    }
}
