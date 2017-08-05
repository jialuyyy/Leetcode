public class FindMinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ret = new ArrayList<Integer>();
        if (edges == null) {
            return ret;
        }
        
        if (n == 1) {
            ret.add(0);
            return ret;
        }
        
    
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<Integer>());
        }
        
        for (int[] edge: edges) {
            int e1 = edge[0];
            int e2 = edge[1];
            
            map.get(e1).add(e2);
            map.get(e2).add(e1);
            
        }
        
        List<Integer> leaves = new ArrayList<Integer>();
        //the key with only one neighbor will be the outer most layer
        for (int i = 0; i < n; i++) {
            if (map.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        
        //if less than two leaves in the list, which means we find our result
        while (n > 2) {
            n = n - leaves.size();
            
            List<Integer> newLeaves = new ArrayList<Integer>();
            
            for (int i: leaves) {
                Set<Integer> set = map.get(i);
                //only 1 element will be in the set, becuase i is the leave
                int value = set.iterator().next();
                
                //remove the leave from the value's set
                map.get(value).remove(i);
                
                //when the value becomes leave, add it to the new leave's set
                if (map.get(value).size() == 1) {
                    newLeaves.add(value);
                }
            }
            
            leaves = newLeaves;
            
        }
        
        return leaves;
        
        
        
        
    }
}
