//beats 61.73%
//use a hashmap to keep a key-value pair, where key is the character and value is the appearing times.
//use two pointers, i points to the start of the substring and the j points to the end of the substring
//Time Complexity: O(n)
//Space Complexity: O(n)
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) {
            return 0;
        }
        
        if (s.length() == 0) {
            return 0;
        }
        int j = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int len = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            
            while (j < s.length() && map.size() <= 2) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.size() > 2) {
                    j++;
                    break;
                }
                len = Math.max(len, j - i + 1);
                j++;
            }
            
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) - 1);
            if (map.get(cur) == 0) {
                map.remove(cur);
            }
        }
        
        
        return len;
    }
}
