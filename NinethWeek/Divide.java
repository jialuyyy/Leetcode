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

//binary search deduction, log(n)
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
        
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        
        int ans = 0;
        
        while (absDividend >= absDivisor) {
            int mul = 1;
            long cur = absDivisor;
            while (absDividend >= (cur << 2)) {
                mul <<= 2;
                cur <<= 2;
            }
            absDividend -= cur;
            ans += mul;
        }
        
        
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            return -ans;
        } 
        return ans;
    }
}


class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        
        if (dividend == Integer.MIN_VALUE && divisor == 1)
            return Integer.MIN_VALUE;
        
        int res = 0;
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        
        while (dvs <= dvd) {
            long temp = dvs;
            long mul = 1;
            
            while (dvd >= temp << 1) {
                temp = temp << 1;
                mul = mul << 1;
            }
            
            dvd = dvd - temp;
            res += mul;
        }
        
        return sign == 1 ? res : -res;
    }
}
