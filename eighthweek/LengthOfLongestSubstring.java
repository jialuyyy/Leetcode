//two pointers: one points to the start of the substring while the other one points to the end of the substring
//while j is less than the length of the string and the appearing times of s.charAt(j) == 0, increase both the frequency in the
//hash array and j, update the max length when out of the while loop, remove the character at i at the end of the for loop.

// as two pointers never go back, so the time complexity is O(n)

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] hash = new int[128];
        int j = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && hash[s.charAt(j)] == 0) {
                hash[s.charAt(j)]++;
                j++;
            }
            
            maxLen = Math.max(j - i, maxLen);
            
            hash[s.charAt(i)]--;
        }
        
        return maxLen == Integer.MIN_VALUE ? 0: maxLen;
    }
}
