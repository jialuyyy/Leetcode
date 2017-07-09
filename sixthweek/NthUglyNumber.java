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

//o(n) solution, reading from Leetcode discussion
//the three 'if' statements already group the duplicates.
//ugly number is ugly number*2 or *5 or*7
/* 1*2 2*2 3*2 4*2 5*2 6*2 8*2.....
   1*3 2*3 3*3 4*3 5*3 6*3 8*3.....
   1*5 2*5 3*5 4*5 5*5 6*5 8*5..... */
public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if (min == factor2) {
                factor2 = 2 * (ugly[++index2]);
            }
            if (min == factor3) {
                factor3 = 3 * (ugly[++index3]);
            }
            if (min == factor5) {
                factor5 = 5 * (ugly[++index5]);
            }
        }
        
        return ugly[n - 1];
    }
}
