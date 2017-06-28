//beats 45.37%
//bfs
//for every level in the bfs, if found a valid string, keep poll the string from the queue and do not push more elements
//as we need to find all the string with least number of characters removed. If we already found valid string at current level, there
//is no need to add more into the stack, and for the valid strings, all the answers would have even number of characters, so 
//there is no need to do the explicit level control.

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new ArrayList<String>();
        if (s == null) {
            return ret;
        }
        
        Queue<String> q = new ArrayDeque<String>();
        Set<String> set = new HashSet<String>();
        boolean found = false;
        set.add(s);
        q.add(s);
        
        while (!q.isEmpty()) {
            String cur = q.poll();
            
            if (isValid(cur)) {
                ret.add(cur);
                found = true;
            }
            
            if (found) {
                continue;
            }
            
            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) != '(' && cur.charAt(i) != ')') 
                    continue;
                
                String str = cur.substring(0, i) + cur.substring(i + 1);
                if (!set.contains(str)) {
                    set.add(str);
                    q.add(str);
                }
            }
        }
        
        return ret;
    }
    
    private boolean isValid (String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')' && count-- == 0) return false; 
        }
        
        return count == 0;
    }
}
