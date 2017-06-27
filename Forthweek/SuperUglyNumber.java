//beats 19.58
//Time Complexity: O(nlog(n))
//Space Complexity: O(n)
//use a min heap to locate next minimum value, use an array to maintain the current super ugly number array, use every prime number to multiply
//the current super ugly number and push it into the minheap. use a while loop to avoid duplicates.

public class SuperUglyNumber {
    class Pair {
        int index;
        int val;
        int prime;
        
        public Pair(int index, int val, int prime) {
            this.index = index;
            this.val = val;
            this.prime = prime;
        }
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] uglyNumber = new int[n];
        uglyNumber[0] = 1;
        
        Queue<Pair> pq = new PriorityQueue<Pair>(n, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) {
                return p1.val - p2.val;
            }
        });
        
        for (int prime: primes) {
            pq.offer(new Pair(0, prime, prime));
        }
        
        for (int i = 1; i < n; i++) {
            Pair cur = pq.peek();
            uglyNumber[i] = cur.val;
            
            do {
                cur = pq.poll();
                cur.val = uglyNumber[++cur.index] * cur.prime;
                pq.offer(cur);
            } while (!pq.isEmpty() && pq.peek().val == uglyNumber[i]);
        }
        
        return uglyNumber[n - 1];
        
    }
}
