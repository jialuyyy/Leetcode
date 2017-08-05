public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();
        Map<Integer, Set<Integer>>  neighbors = new HashMap<Integer, Set<Integer>>();
        
        for (int i = 0; i < numCourses; i++) {
            indegree.put(i, 0);
            neighbors.put(i, new HashSet<Integer>());
        }
        
        for (int[] prerequisite: prerequisites) {
            int pre1 = prerequisite[0];
            int pre2 = prerequisite[1];
            
            if (pre1 < 0 || pre1 > numCourses - 1 || pre2 < 0 || pre2 > numCourses - 1) {
                return false;
            }
            if (!neighbors.get(pre2).contains(pre1)) {
                neighbors.get(pre2).add(pre1);
                indegree.put(pre1, indegree.get(pre1) + 1);
            }
        }
        
        Deque<Integer> q = new ArrayDeque<Integer>();
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree.get(i) == 0) {
                q.offer(i);
            }
        }
        
        if (q.isEmpty()) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        while(!q.isEmpty()) {
            int cur = q.poll();
            set.add(cur);
            
            for (int neighbor: neighbors.get(cur)) {
                int in = indegree.get(neighbor) - 1;
                indegree.put(neighbor, in);
                if (in == 0) {
                    q.offer(neighbor);
                }
            }
        }
        
        return set.size() == numCourses;
    }
}
