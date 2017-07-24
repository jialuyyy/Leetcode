//Time Complexity: O(n)
//Space Complexity: O(n)

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        //used to maintain the appearing times of each characters in the string
        int[] freq = new int[26];
        
        //used to maintain if the current character is visited or not
        boolean[] visited = new boolean[26];
        
        //used to maintain the sequence of nonduplicate letters
        Deque<Character> stack = new ArrayDeque<Character>();
        
        for (char c: s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        for (char c: s.toCharArray()) {
            
            //if already visited, which means do not need to push into the stack
            freq[c - 'a']--;
            
            if (visited[c - 'a'])
                continue;
            
            //if  current character is less than the top element in the stack and the top element still exists in the 
            //following letters, pop the current element out of the stack and set the visited to be false
            
            while (!stack.isEmpty() && stack.peekLast() > c && freq[stack.peekLast() - 'a'] > 0) {
                visited[stack.pollLast() - 'a'] = false;
            }
            
            //push the current element into the stack and set the visited to be true
            stack.offerLast(c);
            visited[c - 'a'] = true;
        }
        
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pollLast());
        }
        
        return sb.toString();
        
    }
}
