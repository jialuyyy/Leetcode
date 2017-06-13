//brute force, check every pair of words and concatenate them to see if it's a palindrome or not.
//O(kn ^ 2), n is the length of the words array and k is the average length of two strings length
//Time limit exceeds, need to do optimization

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (words == null || words.length == 0) {
            return ret;
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String str1 = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String str2 = words[j];
                String str1str2 = str1 + str2;
                if (isPalindrome(str1str2)) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(j);
                    ret.add(list);
                }
                
                String str2str1 = str2 + str1;
                
                    if (isPalindrome(str2str1)) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(j);
                        list.add(i);
                        ret.add(list);
                    }
                
            }
        }
        
        return ret;
    }
    
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
}
