
//dp create a hashmap array with key,value pair difference and arith sequence size to current index i 
//time complexity : O(n ^ 2)
//space complexity : O(n)
class LongestArithSeqLength {
    public int longestArithSeqLength(int[] A) {
        int res = 2;
        int n = A.length;
        HashMap<Integer, Integer>[] maps = new HashMap[n];
        for (int i = 0; i < n; i++) {
            maps[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int d = A[i] - A[j];
                maps[i].put(d, maps[j].getOrDefault(d, 1) + 1);
                res = Math.max(res, maps[i].get(d));
            }
        }
        
        return res;
    }
}
