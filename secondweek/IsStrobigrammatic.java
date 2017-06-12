//beats 55.81
//Time Complexity: O(n)
//thoughts: like palindromatic number solution. Two pointers, one starts from the head and the other starts from the tail and these two
//pointers move toward each other until they meet.

public class IsStrobigrammatic {
    public boolean isStrobogrammatic(String num) {
        if (num == null) {
            return false;
        }
        
        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            if (!("11 88 696 00").contains(num.charAt(i) + "" + num.charAt(j))) {
                return false;
            }
        }
        
        return true;
        
    }
}


//use a hashmap to store the mirror character pair
//two pointers move toward each other to judge if this string is strobogrammatic
//Time Complexity: O(n)
//Space Complexity: O(n)
//beats 9.16%
public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null) {
            return false;
        }
        
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('9', '6');
        map.put('6', '9');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        
        int left = 0;
        int right = num.length() - 1;
        
        while (left <= right) {
            if (map.get(num.charAt(left)) == null) {
                return false;
            }
            
            if (map.get(num.charAt(left)) != num.charAt(right)) 
                return false;
            
            left++;
            right--;
        }
        
        return true;
        
    }
}
