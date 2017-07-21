//two pointers
//i points to the start of the substring while j points to the end of the substring, use a hashmap to maintain the frequency of 
//each character and hashmap's size will be the number of the distinct elements, use the size of the hashmap as the condition of the 
//while loop

//Time complexity : as the two pointers keep moving forward, the time complexity will be O(n)
//Space Complexity: as we use a hashmap to maintain the frequency, space complexity will be O(n)

public class LengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        
        int j = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            
            while (j < s.length()) {
                
                char cur = s.charAt(j);
                if (frequency.get(cur) != null && frequency.size() <= k) {
                    frequency.put(cur, frequency.get(cur) + 1);
                    j++;
                } else {
                    if (frequency.size() >= k) {
                        break;
                    } else {
                        frequency.put(cur, 1);
                        j++;
                    }
                    
                }
                
                
            }
            
            
            maxLen = Math.max(maxLen, j - i);
            
            char removed = s.charAt(i);
            if (frequency.get(removed) != null) {
                int freq = frequency.get(removed);
            
                if (freq == 1) {
                    frequency.remove(removed);
                } else {
                    frequency.put(removed, freq - 1);
                }
            }
            
        }
        
        return maxLen == Integer.MIN_VALUE? 0: maxLen;
    }
}
