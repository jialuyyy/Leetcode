class FindSmallestRegion {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        //region and parent hashmap
        Map<String, String> parents = new HashMap<>();
        
        for (List<String> region : regions) {
            if (region != null && region.size() > 0) {
                String parent = region.get(0);
                
                for (int i = 1; i < region.size(); i++) {
                    String child = region.get(i);
                    if (parents.get(child) == null) {
                        parents.put(child, parent);
                    }
                }
            }
        }
        
        Set<String> hashSet = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        
        queue.offer(region1);
        hashSet.add(region1);
        
        queue.offer(region2);
        hashSet.add(region2);
        
        
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            
            String p = parents.get(cur);
        
            
            if (!hashSet.contains(p)) {
                if (p != null) {
                    queue.offer(p);
                    hashSet.add(p);
                }
                
            } else {
                return p;
            }
        }
        
        return null;
    }
}
