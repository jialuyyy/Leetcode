//Time Complexity: O(n)
//Space Complexity: O(n) two maps and one queue
//beats 52.04%
//use two hashmaps, one is used to maintain the neighbors of every course and another one is used to maintain the indegree of every course
//if indegree is equal to 0, which means this course has no prerequisite to take, so push it into the queue first
//iterate over the elements in the queue, for the neighbors of every element, decrease its indegree, if the indegree is 0, which means can take
//this course, so push it into the queue, polling the element means finishing the course, and every time finishes one course,
//increase the count variable
//check whether the variable equals to the total number of courses in the end

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
