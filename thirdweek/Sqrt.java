//beats 19.60%
//be careful of mid * mid will larger than the max value of int, so convert them to long

public class Sqrt {
    public int mySqrt(int x) {
        long start = 1;
        long end = x;
        
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid > x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (end * end <= x) {
            return (int)end;
        }
        
        return (int)start;
    }
}
