class GetPermutation {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> numbers = new ArrayList<>();
        
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
            numbers.add(i);
        }
        
        int end = k - 1;
        
        for (int i = 0; i < n; i++) {
            factorial = factorial / (n - i);
            int index = end / factorial;
            sb.append(numbers.remove(index));
            end = end - index * factorial;
        }
        
        return sb.toString();
    }
}
