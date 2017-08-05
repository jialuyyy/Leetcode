public class AlienOrder {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        
        Map<Character, Integer> indegree = new HashMap<Character, Integer>();
        Map<Character, HashSet<Character>> map = new HashMap<Character, HashSet<Character>>();
        for (int i = 0; i < words.length; i++) {
            char[] ch = words[i].toCharArray();
            for (char c : ch) {
                if (!indegree.containsKey(c)) {
                    indegree.put(c, 0);
                }
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            
            int len1 = word1.length();
            int len2 = word2.length();
            
            int len = Math.min(len1, len2);
            
            for (int j = 0; j < len; j++) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                
                if (ch1 != ch2) {
                    if (map.get(ch1) == null) {
                        map.put(ch1, new HashSet<Character>());
                    }
                    
                    if (!map.get(ch1).contains(ch2)) {
                        map.get(ch1).add(ch2);
                        indegree.put(ch2, indegree.get(ch2) + 1);
                    }
                    
                    break;
                }
            }
        }
        
        Deque<Character> q = new ArrayDeque<Character>();
        
        for (char ch: indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                q.offer(ch);
            }
        }
        
        if (q.isEmpty()) {
            return "";
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        while (!q.isEmpty()) {
            char cur = q.poll();
            sb.append(cur);
            if (map.get(cur) != null) {
                for (char c: map.get(cur)) {
                    int in = indegree.get(c) - 1;
                    indegree.put(c, in);
                    if (in == 0) {
                        q.offer(c);
                    }
                }
            }
        }
        
        return sb.toString().length() == indegree.size() ? sb.toString() : "";
        
    }
}
