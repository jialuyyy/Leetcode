//beats 54.13%
//use an array to maintain the appearing times of each character in the magazine
//iterate over the ransomNote character to check if the array value of this character is greater than 0, if not, return false.
//two passes Time Complexity: O(n)
//Space Complexity: O(n)
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null || ransomNote.length() > magazine.length()) {
            return false;
        }
    
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            arr[c - 'a']++; 
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (arr[c - 'a'] > 0) {
                arr[c - 'a']--;
            } else {
                return false;
            }
        }
        
        return true;
    }
}
