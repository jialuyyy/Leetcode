//Time limit exceeds
//need to do optimization
public class NthSuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
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
            for (int prime: primes) {
                long next = cur * prime;
                
                if (!set.contains(next)) {
                    queue.offer(next);
                    set.add(next);
                }
            }
        }
        
        return -1;
    }
}


//Time Complexity : O(nk)
//not easy to come up with, should do again
//beats 35%
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] index = new int[primes.length];
        int[] ret = new int[n];
        ret[0] = 1;
        
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            
            for (int j = 0; j < index.length; j++) {
                min = Math.min(ret[index[j]] * primes[j], min);
            }
            
            ret[i] = min;
            
            for (int k = 0; k < index.length; k++) {
                if (min % primes[k] == 0) {
                    index[k]++;
                }
            }
        }
        
        return ret[n - 1];
    }
}
