//beats 82.56%
//two pointers, i points to the start of the whole string and j points to the end of the substring, if the current value has not appeared 
//yet, update the j and update the length, if already exist, decrease the array and then move the i pointer.
//Time Complexity: O(n)
//Space Complexity: O(n)
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] hash = new int[128];
        int j = 0;
        int len = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && hash[s.charAt(j)] == 0) {
                hash[s.charAt(j)]++;
                len = Math.max(len, j - i + 1);
                j++;
            }
            
            hash[s.charAt(i)]--;
        }
        
        return len;
        
    }
}
