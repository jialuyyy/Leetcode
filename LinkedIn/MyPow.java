//divide the problem into sub problem the size n / 2
//if n / 2 is even, do myPow(x, n / 2) *myPow(x, n / 2)
//else myPow(x, n / 2) *myPow(x, n / 2) * x if (n > 0)
// if (n < 0) myPow(x, n / 2) *myPow(x, n / 2) / x
public class MyPow {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        
        double temp = myPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            if (n > 0) {
                return x * temp * temp;
            } else {
                return temp * temp / x;
            }
            
        }
    }
}
