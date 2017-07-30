//time limit exceeds as the time complexity is O(n)
public class Divide {
    public int divide(int dividend, int divisor) {
        
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
        }
        
        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);
        
        int ans = 0;
        while (absDividend - absDivisor >= 0) {
            ans++;
            absDividend -= absDivisor;
        }
        
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            return -ans;
        } 
        return ans;
    }
}
