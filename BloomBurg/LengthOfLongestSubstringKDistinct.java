public class LengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int j = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                if (map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                    j++;
                } else {
                    if (map.size() < k) {
                        map.put(s.charAt(j), 1);
                        j++;
                    } else {
                        break;
                    }
                }
            }
            
            maxLen = Math.max(maxLen, j - i);
            
            if (map.get(s.charAt(i)) == 1)
                map.remove(s.charAt(i));
            else
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        }
        
        return maxLen;
    }
    
}
