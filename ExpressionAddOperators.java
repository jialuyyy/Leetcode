/*Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"] 
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []*/

//backtracking


class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ret = new ArrayList<>();
        
        helper(num, target, "", 0, 0, 0, ret);
        return ret;
    }
    //pos: current index we are operating on
    //prevNum: used to operate on multiply operator. for 1 + 2 * 3, it will be 9, so we need to do (1 + 2 - 2) + 2 * 3
    //to get 7
    private void helper(String num, int target, String path, int pos, long curRes, long prevNum, List<String> ret) {
        if (pos >= num.length()) {
            if (curRes == target) {
                ret.add(new String(path));
                return;
            }
        }
        
        //i is used to build the substring. the outer level should be pos from 0 to num.length()
        //and for each of the outer level, we need to backtrack and get all the operands combinations
        for (int i = pos; i < num.length(); i++) {
          
            //if i != pos and num.charAt(pos） == ‘0’， which means we need to discard substrings like "05" starting from 0
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
