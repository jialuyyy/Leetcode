class AddDigits {
    public int addDigits(int num) {
        int sum = 0;
        
        while (true) {
            sum = 0;
            while (num != 0) {
                int cur = num % 10;
                num = num / 10;
                
                sum += cur;
            }
            
            if (sum / 10 == 0) {
                return sum;
            }
            
            num = sum;
        }
    }
}
