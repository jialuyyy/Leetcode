class ReorganizeString {
    public String reorganizeString(String S) {
        if (S == null || S.length() == 0)
            return "";
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(S.length(), new Comparator<Map.Entry<Character, Integer>>(){
            public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        });
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> cur = pq.poll();
            
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != cur.getKey()) {
                sb.append(cur.getKey());
                
                if (cur.getValue() - 1 > 0) {
                    cur.setValue(cur.getValue() - 1);
                    pq.offer(cur);
                }
            } else {
                Map.Entry<Character, Integer> cur2 = pq.poll();
                if (cur2 == null) {
                    return "";
                }
                
                sb.append(cur2.getKey());
                if (cur2.getValue() - 1 > 0) {
                    cur2.setValue(cur2.getValue() - 1);
                    pq.offer(cur2);
                }
                pq.offer(cur);
            }
            
            
            
        }
        
        return sb.toString();
    }
}
