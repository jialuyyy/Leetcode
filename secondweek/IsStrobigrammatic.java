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
