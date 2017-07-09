//Time Complexity: O(nlog(n))
//Space Complexity:O(n)
//beats 10%
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        Queue<Long> queue = new PriorityQueue<Long>();
        Set<Long> set = new HashSet<Long>();
        set.add((long)1);
        queue.offer((long)1);
        
        int count = 0;
        while (!queue.isEmpty()) {
            long cur = queue.poll();
            count++;
            
            if (count == n) {
                return (int)cur;
            }
            long next1 = cur * 2;
            long next2 = cur * 3;
            long next3 = cur * 5;
            
            if (!set.contains(next1)) {
                queue.offer(next1);
                set.add(next1);
            }
            if (!set.contains(next2)) {
                queue.offer(next2);
                set.add(next2);
            }
            if (!set.contains(next3)) {
                queue.offer(next3);
                set.add(next3);
            }
        }
        
        return -1;
    }
}
