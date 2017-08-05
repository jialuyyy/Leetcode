public class FindItinerary {
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> ret = new LinkedList<String>();
        
        if (tickets == null || tickets.length == 0) {
            return ret;
        }
        
        Map<String, Queue<String>> map = new HashMap<String, Queue<String>>();
        
        
        for (String[] ticket: tickets) {
            String de = ticket[0];
            String ar = ticket[1];
            
            if (map.get(de) == null) {
                map.put(de, new PriorityQueue<String>());
            }
            
            map.get(de).add(ar);
        }
        
        dfs("JFK", ret, map);
        
        return ret;
    } 
    
    private void dfs(String de, LinkedList<String> ret, Map<String, Queue<String>> map) {
        Queue<String> pq = map.get(de);
        
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll(), ret, map);
        }
         
        ret.addFirst(de);
    }
    
}
