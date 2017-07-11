//beats 11%
//build a hashmap to keep the character and the characters after it.
//build a indegree hashmap to keep all the indegrees of every character
//offer the character into the queue if its indegree is decreased to 0
//need to note some special case: "za" "zb" "ca" "cb", in this case {a} {b} pair appears twice, so we need to do something to avoid duplicates
//use a hashset is a way to avoid duplicate
public class AlienDictionary {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        
        String ret = new String();
        
        Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        Map<Character, Integer> indegree = new HashMap<Character, Integer>();
        
        //initailize the indegree map
        for (String word: words) {
            for (int i = 0; i < word.length(); i++) {
                if (indegree.get(word.charAt(i)) == null) {
                    indegree.put(word.charAt(i), 0);
                }
            }
        }
                    
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            
            int len = Math.min(s1.length(), s2.length());
            
            for (int j = 0; j < len; j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if (c1 != c2) {
                    if (map.get(c1) == null) {
                        map.put(c1, new HashSet<Character>());
                    }
                    
                    // the if statement is used to avoid duplicates 
                    if (!map.get(c1).contains(c2)) {
                        map.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        
        Deque<Character> q = new ArrayDeque<Character>();
        for (Map.Entry<Character, Integer> entry: indegree.entrySet()) {
            char c = entry.getKey();
            int degree = entry.getValue();
            
            if (degree == 0) {
                q.offer(c);
            }
        }
        
        while (!q.isEmpty()) {
            char cur = q.poll();
            ret += String.valueOf(cur);
            Set<Character> set = map.get(cur);
            if (set != null) {
                for (char c: set) {
                    indegree.put(c, indegree.get(c)-1);
                
                    if (indegree.get(c) == 0) {
                        q.offer(c);
                    } 
                }
            }
        }
        
        return ret.length() == indegree.size()? ret: "";
    }
}
