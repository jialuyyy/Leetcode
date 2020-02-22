//only one bit is 1 for numbers that is power of 2
//100, 10, 1, 1000, 10000
//so 011 & 100; 10 & 01; 1000 & 0111 are all 0
class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
       if (n <= 0)
           return false;
        
        return (n & (n - 1)) == 0;
    }
}
