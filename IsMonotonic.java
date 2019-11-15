//two pass
//iterate over the array for two times, the first time to check if it is increasing and the other time to check if it is 
//decreasing;

//Time complexity(O(2N))
class IsMonotonic {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 0)
            return false;
    
       return increasing(A) || decreasing(A);
    }
    
    private boolean increasing(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1])
                return false;
        }
        
        return true;
    }
    
    private boolean decreasing(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1])
                return false;
        }
        
        return true;
    }
}
