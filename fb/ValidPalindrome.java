//two pointers: beats 60%
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }    
        
        s = s.trim();
        
        int start = 0;
        int end = s.length() - 1;
        
        while (start < end) {
            char ch1 = s.charAt(start);
            char ch2 = s.charAt(end);
            
            if (!Character.isLetterOrDigit(ch1)) {
                start++;
            } else if (!Character.isLetterOrDigit(ch2)) {
                end--;
            } else {
            
                if (Character.toLowerCase(ch1) == Character.toLowerCase(ch2)) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}
