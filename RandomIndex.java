//O(n) for every pickIndex() need to make improvements
class RandomIndex {
    private int[] accumulated = null;
    private Random random = new Random();
    public RandomIndex(int[] w) {
        if (w == null || w.length == 0)
            return;
        accumulated = new int[w.length];
        accumulated[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            accumulated[i] = w[i] + accumulated[i - 1];
        }
    }
    
    public int pickIndex() {
        //get the random value between 0(inclusive) and accumulated[accumulated.length - 1](exclusive)
        int rand = random.nextInt(accumulated[accumulated.length - 1]);
        
        //map it to the index
        if (accumulated[0] > rand)
            return 0;
        int i = 1;
        for (i = 1; i < accumulated.length; i++) {
            if (rand >= accumulated[i - 1] && rand < accumulated[i])
                return i;
        }
        
        return i;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
