public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int maxLen = Integer.MIN_VALUE;
        int[] hash = new int[128];
        
        int j = 0;
        
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && hash[s.charAt(j)] == 0) {
                hash[s.charAt(j)]++;
                j++;
            }
            
            maxLen = Math.max(maxLen, j - i);
            hash[s.charAt(i)]--;
        }
        
        return maxLen;
    }
}


//Input: "abcabcbb"
//Output: 3 
//Input: "pwwkew"
//Output: 3

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        int maxLen = 0;
        
        int i = 0;
        int j = 0;
        
        int[] map =  new int[256];
        
        while (j < s.length()) {
            map[s.charAt(j)]++;
            
            while (map[s.charAt(j)] > 1) {
                map[s.charAt(i)]--;
                i++;
            }
            
            maxLen = Math.max(maxLen, j - i + 1);
            
            j++;
        }
        
        return maxLen;
    }
}
