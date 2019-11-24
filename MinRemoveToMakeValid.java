//we have to make sure the left parenthese matches the number of the right parenthese from beginning to end and the right
//parenthese matches the left parenthese from end to beginning

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
