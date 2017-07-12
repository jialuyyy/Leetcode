//use two array to keep the character appearing times, one is to keep the character appearing times in the target array
//iterate over the source string, if the appearing times for the current character is less than or equal to the times in the target map,
//counter++, if the counter equals to the length of the target string, check whether we can remove some characters from the start,
//if the appearing times of the current character is larger than the appearing time in the target map, decrease the value and increase
//the start pointer
//update the minLne and use start_index to record the start of the substring
//Time Complexity : O(n)
//Space Complexity: O(1) as the space will not get larger. it is always 256
public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        if ( s == null || t == null || t.length() > s.length()) {
            return "";
        }
        String ret = "";
        int[] mapT = new int[256];
        int[] mapS = new int[256];
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            mapT[ch]++;
        }
        
        int start_index = -1;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            mapS[ch]++;
            
            if (mapS[ch] <= mapT[ch]) {
                count++;
            }
            
            if (count == t.length()) {
                while (mapS[s.charAt(start)] > mapT[s.charAt(start)]) {
                    mapS[s.charAt(start)]--;
                    start++;
                }
                
                if (minLen > j - start + 1) {
                    minLen = j - start + 1;
                    start_index = start;
                }
            }
        }
        
        if (start_index == -1) {
            return "";
        }
       
        
        return s.substring(start_index, start_index + minLen);
    }
}
