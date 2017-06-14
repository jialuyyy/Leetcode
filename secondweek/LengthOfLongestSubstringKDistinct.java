public class LengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null) {
            return 0;
        }
        
        if (s.length() == 0 || k == 0) {
            return 0;
        }
        int j = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int len = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            
            while (j < s.length() && map.size() <= k) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.size() > k) {
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
