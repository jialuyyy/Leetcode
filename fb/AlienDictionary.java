//beats 11%
//build a hashmap to keep the character and the characters after it.
//build a indegree hashmap to keep all the indegrees of every character
//offer the character into the queue if its indegree is decreased to 0
//need to note some special case: "za" "zb" "ca" "cb", in this case {a} {b} pair appears twice, so we need to do something to avoid duplicates
//use a hashset is a way to avoid duplicate

class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0)
            return "";
        
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, Set<Character>> afterC = new HashMap<>();
        
        //initialize the indegree map
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (indegree.get(words[i].charAt(j)) == null) {
                    indegree.put(words[i].charAt(j), 0);
                }
            }
        }
        //z 0  a 0 b 0
        
        
        //a (b)
        //z (c)
        //
        for (int i = 0; i < words.length - 1; i++) {
            
            String word1 = words[i];
            String word2 = words[i + 1];
            
            int len = Math.min(word1.length(), word2.length());
            
            for (int j = 0; j < len; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                
                if (c1 != c2) {
                    if (afterC.get(c1) == null)
                        afterC.put(c1, new HashSet<>());
                
                    if (!afterC.get(c1).contains(c2)) {
                        afterC.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    
                    
                    //["za","zb","ca","cb"] 
                    //if we do not have the break here,
                    //when it comes to "zb", "ca"
                    //if will put both z, c and b, a into the map
                    //which will cause an issue, becuase b should be after
                    //a
                    break;
                }
                
            }
        }
        
        
        Deque<Character> queue = new ArrayDeque<>();
            
        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            char key = entry.getKey();
            int degree = entry.getValue();
                
            if (degree == 0)
                queue.offer(key);
        }
        String ret = "";
        
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            ret += String.valueOf(cur);
            
            Set<Character> set = afterC.get(cur);
            if (set != null) {
                for (char c : set) {
                    indegree.put(c, indegree.get(c) - 1);
                    
                    if (indegree.get(c) == 0)
                        queue.offer(c);
                }
            }
        }
        
        
        return ret.length() == indegree.size() ? ret : "";
        
        
    }
}
