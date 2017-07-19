import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	//"abbbbacccd" k = 1
	
    public static int lengthOfShortestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
        	while (j < s.length() && map.size() < k) {
        		if (map.containsKey(s.charAt(j))) {
        			map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
        		} else {
        			map.put(s.charAt(j), 1);
        		}
        		j++;
        	}
        	
        	if (map.size() == k)
        	    minLen = Math.min(minLen, j - i);
        	if (map.get(s.charAt(i)) == 1) {
        		map.remove(s.charAt(i));
        	} else {
        		map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        	}
        }
        return minLen == Integer.MAX_VALUE? 0: minLen;
    }
    
    public static void main(String[] args) {
    	String s = "abbbbacccd";
    	System.out.print(lengthOfLongestSubstringTwoDistinct(s, 4));
    	
    }
}
