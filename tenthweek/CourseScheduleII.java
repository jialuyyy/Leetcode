public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();
        Map<Integer, Set<Integer>> neighbors = new HashMap<Integer, Set<Integer>>();
        
        int[] ret = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            indegree.put(i, 0);
            neighbors.put(i, new HashSet<Integer>());
        }
        
        for (int[] prerequisite: prerequisites) {
            int pre1 = prerequisite[0];
            int pre2 = prerequisite[1];
            
            if (pre1 < 0 || pre1 >= numCourses || pre2 < 0 || pre2 >= numCourses) {
                return new int[]{};
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
            return new int[]{};
        }
        
        int index = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            ret[index++] = cur;
            
            for (int neighbor: neighbors.get(cur)) {
                int in = indegree.get(neighbor) - 1;
                if (in == 0) {
                    q.offer(neighbor);
                }
                
                indegree.put(neighbor, in);
            }
        }
        
        return index == numCourses? ret : new int[]{};
    }
    
}
