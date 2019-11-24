//to make a string valid, we need to get rid of all parenthese that do not have a matching pair
//1 push character ( into the stack
//2 pop character ( out of the stack when coming accross ) and the stack is not empty, if the stack is empty, means we have 
//a ) do not have a matching (, so we need to remove it from the string
//3. in the end, the stack will only contain ( have no matching )
class MinRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0)
            return s;
        
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> removedIndexes = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    removedIndexes.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        
        while(!stack.isEmpty()) {
            removedIndexes.add(stack.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!removedIndexes.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}

//use place holder * to mark the removed character
class Solution {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0)
            return s;
        
       StringBuilder sb = new StringBuilder(s);
       Stack<Integer> st = new Stack<>();
       for (int i = 0; i < sb.length(); ++i) {
           if (sb.charAt(i) == '(') st.add(i);
           if (sb.charAt(i) == ')') {
               if (!st.empty()) 
                   st.pop();
               else 
                   sb.setCharAt(i, '*');
         }
       }
       while (!st.empty())
           sb.setCharAt(st.pop(), '*');
       return sb.toString().replaceAll("\\*", "");
    }
}
