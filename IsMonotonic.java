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

//One pass solution, use a variable to keep track of the increasing or decreasing flag between two adjacent elements;
//if we found it get changed, return false
class Solution {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 0)
            return false;
       
        int comparator = 0;
        for (int i = 0; i < A.length - 1; i++) {
            int c = Integer.compare(A[i], A[i + 1]);
            if (c != 0) {
                if (comparator != c && comparator != 0) {
                    return false;
                }
                comparator = c;
            }
        }
        
        return true;
    }
    
    
}
