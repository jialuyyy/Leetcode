//brute force, check every pair of words and concatenate them to see if it's a palindrome or not.
//O(kn ^ 2), n is the length of the words array and k is the average length of two strings length
//Time limit exceeds, need to do optimization

public class PalindromePairs {
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

//Time Complexity: O(n * (k ^ 2)) k is the average length of each word and n is the length of the string array
//Space Complexity: O(n), use hashmap to locate the word in the string array
//thoughts: iterate over each word in the words array. split each word into two substrings, if one of the two substrings is a palindrome
//then just need to locate if the words array contains a string that is the reverse of the other substring. If it is, we find one solution.
//Compared with the brute force solution, this solution optimized the algorithm by decreasing one iteration.

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (words == null || words.length == 0) {
            return ret;
        }
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) {
            
            for (int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                
                if (isPalindrome(str1)) {
                    String target = new StringBuilder(str2).reverse().toString();
                    if (map.get(target) != null && map.get(target) != i) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(target));
                        list.add(i);
                        ret.add(list);
                    }
                }
                
                if (isPalindrome(str2)) {
                    String target = new StringBuilder(str1).reverse().toString();
                    if (map.get(target) != null && map.get(target) != i && str2.length() != 0) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(target));
                        ret.add(list);
                    }
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
