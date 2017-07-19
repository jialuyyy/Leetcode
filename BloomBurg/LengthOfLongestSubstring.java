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
