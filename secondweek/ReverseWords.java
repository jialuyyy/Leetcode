//beats: 42.13
//thoughts: reverse the whole char array; then reverse the char array word by word
//first reverse: O(n)
//second reverse: O(n)
//Time complexity:O(n)
public class ReverseWords {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        reverse(s, 0, s.length - 1);
        
        int left = 0;
        int right = 0;
        
        while (right < s.length) {
            while (right < s.length && s[right] != ' ') {
                right++;
            }
            
            reverse(s, left, right - 1);
            left = right + 1;
            right = right + 1;
        }
    }
    
    private void reverse(char[] s, int start, int end) {
       
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            
            start++;
            end--;
        }
    }
    
   
}
