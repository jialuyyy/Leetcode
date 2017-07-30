// 1 ＋ 2 ＋ 3
// 1 + 2 - 3
// 1 + 2 * 3

// if not saving the multiplied element, it will be  (1 + 2) * 3
// so we need to decrease the 2 first, and do the multiplication (1 + 2 - 2) + 2 * 3
//we need to save the 2 for the next recursion


public class AddOperators {
    public List<String>  addOperators(String num, int target) {
        List<String> ret = new ArrayList<String>();
        if (num == null) {
            return ret;
        }
        
        helper(num, target, "", 0, 0, 0, ret);
        return ret;
    }
    
    
    //num is the string
    //target is the target value
    //path keeps the current string 
    //pos keeps the current position we are operating on
    //curRes keeps the current result
    //preNum keeps the previous value that we need to deduct for the next multiplication operation
    
    private void helper(String num,int target, String path, int pos, long curRes, long prevNum, List<String> ret) {
        if (pos == num.length()) {
            if (curRes == target) {
                ret.add(new String(path));
                return;
            }
        }
        
        // i is actually the length of the substring that starting from pos
        //so when i != pos, but cur.charAt(pos) == '0', which means the substring is longer than 1 and the first digit is 0,
        //we need to discard this case
        
        for (int i = pos; i < num.length(); i++) {
            //"00" case is excluded
            //i != pos means that we already 
            if (i != pos && num.charAt(pos) == '0') {
                return;
            }
            
            String cur = num.substring(pos, i + 1);
            long curNum = Long.parseLong(cur);
        
            
            if (pos != 0) {
                helper(num, target, path + "+" + cur, i + 1, curRes + curNum, curNum, ret);
                helper(num, target, path + "-" + cur, i + 1, curRes - curNum, -curNum, ret);
                helper(num, target, path + "*" + cur, i + 1, (curRes - prevNum) + prevNum * curNum, prevNum * curNum, ret);
            } else {
                helper(num, target, cur, i + 1, curNum, curNum, ret);
            }
            
        }
    }
    
    
}

//more straight forward than the previous one,
// 1, 2, 3
// 1, 23
// 12, 3
// 123

// if not saving the multiplied element, it will be  (1 + 2) * 3
// so we need to decrease the 2 first, and do the multiplication (1 + 2 - 2) + 2 * 3
//we need to svae the 2 for the next recursion

//curRes current calculation result
//prevNum the addend or the su substractor of last time

// i is the partition position of the current and next substring
//i = 1 =>  1 (2, 3) => 1 (2) (3) => trace back 1 (23) => trace back (12) 3 => trace back (123) 
public class Solution {
    public List<String>  addOperators(String num, int target) {
        List<String> ret = new ArrayList<String>();
        if (num == null) {
            return ret;
        }
        
        helper(num, target, "", 0, 0, ret);
        return ret;
    }
    
    private void helper(String num,int target, String path, long curRes, long prevNum, List<String> ret) {
        if (num.length() == 0 && curRes == target) {
            ret.add(new String(path));
            return;
        }
        
        for (int i = 1; i <= num.length(); i++) {
            String cur = num.substring(0, i);
            
            //"00" "01" is invalid return directly
            if (cur.length() > 1 && cur.charAt(0) == '0') {
                return;
            }
            
            long curNum = Long.parseLong(cur);
            String next = num.substring(i);
            
            //1 -> 1 + 2 -> 1+2+3 return
            // 1 + 2 - 3
            // (1 + 2 -2) + 2 * 3
            
            //1 23
            //12 3
            
            if (path.length() != 0) {
                helper(next, target, path + "+" + cur, curRes + curNum, curNum, ret);
                helper(next, target, path + "-" + cur, curRes - curNum, -curNum, ret);
                helper(next, target, path + "*" + cur, (curRes - prevNum) + prevNum * curNum, prevNum * curNum, ret);
            } else {
                //if path.length == 0 avoid + 1
                helper(next, target, cur, curNum, curNum, ret);
            }
            
        }
    }
    
    
}
