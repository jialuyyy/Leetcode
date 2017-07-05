//Time Complexity : O((n - k) * k)
//n is the length of haystack and k is the length of needle

public class Strstr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        
        
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            
            if (j == needle.length()) {
                return i;
            }
        }
        
        return -1;
    }
}
