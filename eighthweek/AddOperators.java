// 1 ＋ 2 ＋ 3
// 1 + 2 - 3
// 1 + 2 * 3

// if not saving the multiplied element, it will be  (1 + 2) * 3
// so we need to decrease the 2 first, and do the multiplication (1 + 2 - 2) + 2 * 3
//we need to svae the 2 for the next recursion


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
