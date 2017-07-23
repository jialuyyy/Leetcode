//Time complexity: O(n)
//two pointers: one points to the start of the substring and the other one points to the end of the substring
//use an array to keep the appearing times of each characters
//the initial value of the array would be the appearing times of the characters in string t
//use a counter to keep the counter of valid characters in current substring, if find one, counter--
//when the counter becomes zero, all the valid characters are found. so update the start index and the length
//start moving the starting pointers, if the hash value of current character is zero, which means a valid character is removed, so increase the 
//counter and out of the current while loop, move the end pointer to find the valid character that is just removed from the substring
public class MinWindow {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int[] hash = new int[128];
       
        //keep the appearing times of every character in t
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;
        }
        
        int startIndex = 0;
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int counter = t.length();
        while (end < s.length()) {
            if (hash[s.charAt(end)] > 0) {
                counter--;
            } 
            hash[s.charAt(end)]--;
            end++;
            while (counter == 0) {
                
                if (minLen > end - start) {
                    minLen = end - start;
                    startIndex = start;
                }
                
                if (hash[s.charAt(start)] == 0) {
                    counter++;
                }
                hash[s.charAt(start)]++;
                start++;
            }
            
        }
        
        
        return minLen == Integer.MAX_VALUE? "": s.substring(startIndex, startIndex + minLen);
    }
}
