public class CourseScheduleI {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();
        Map<Integer, List<Integer>> neighborMap = new HashMap<Integer, List<Integer>>();
        
        for (int i = 0; i < numCourses; i++) {
            indegree.put(i, 0);
            neighborMap.put(i, new ArrayList<Integer>());
        }
        for (int[] prerequisite: prerequisites) {
            //initialize the indegree map
            indegree.put(prerequisite[0], indegree.get(prerequisite[0]) + 1);
            
            //initialize the neighbor map
            neighborMap.get(prerequisite[1]).add(prerequisite[0]);
            
        }
        
        Queue<Integer> q = new ArrayDeque<Integer>();
        
        //offer the courses into the queue if the indegree is 0
        for (int i = 0; i < numCourses; i++) {
            if (indegree.get(i) == 0) {
                q.offer(i);
            }
        }
        
        int count = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            count++;
            
            List<Integer> neighbors = neighborMap.get(course);
            for (int neighbor: neighbors) {
                int cur = indegree.get(neighbor);
                if (--cur == 0) {
                    q.offer(neighbor);
                }
                
                indegree.put(neighbor, cur);
            }
        }
        
        return count == numCourses;
    }
}
