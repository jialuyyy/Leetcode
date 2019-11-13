//abca
//abcbad
//brute force delete each character and check if it is palindrome O(N * N)
//greedy get rid of the tail and head same characters and check if (i, j - 1) or (i + 1, j) is 
//palindrome O(N)
class ValidPalindromeII {
    public boolean validPalindromeII(String s) {
        int start = 0;
        int end = s.length() - 1;
        
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return isPalindrome(s, start, end - 1) || isPalindrome(s, start + 1, end);
            }
            
            start++;
            end--;
        }
        
        return true;
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
}
