class LongestOnes {
    public int longestOnes(int[] A, int K) {
        Deque<Integer> index = new ArrayDeque<>();
        int max = 0;
        for (int l = 0, h = 0; h < A.length; h++) {
            if (A[h] == 0) {
                index.offer(h);
            }
            
            if (index.size() > K) {
                l = index.poll() + 1;
            }
            
            max = Math.max(max, h - l + 1);
        }
        
        return max;
    }
}
