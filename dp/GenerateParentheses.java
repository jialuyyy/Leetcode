//beats 58%
public class GenerateParentheses {
    public List<String>  generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        
        helper(0, 0, "", n, ret);
        return ret;
    }
    
    
    private void helper(int close, int open, String str, int max, List<String> ret) {
        if (str.length() == max * 2) {
            ret.add(str);
            return;
        }
        
        if (open < max) {
            helper(close, open + 1, str + "(", max, ret);
        }
        
        if (close < open) {
            helper(close + 1, open, str + ")", max, ret);
        }
    }
}
