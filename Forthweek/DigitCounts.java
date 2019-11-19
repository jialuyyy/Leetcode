public class DigitCounts {
    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int count = 0;
        for (int i = k; i <= n; i++) {
            count += count(i, k);
        }
        
        return count;
    }
    
    private int count(int i, int k) {
        if (i == 0 && k == 0)
            return 1;
        int count = 0;
        while(i > 0) {
            if (i % 10 == k) {
                count++;
            }
            i = i / 10;
        }
        
        return count;
    }
}
