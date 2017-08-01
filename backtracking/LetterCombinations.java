public class LetterCombinations {
    
    private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return ret;
        }
        
        helper(ret, new StringBuilder(), 0, digits);
        return ret;
    }
    
    private void helper(List<String> ret, StringBuilder sb, int pos, String digits) {
        if (pos == digits.length()) {
            ret.add(sb.toString());
            return;
        }
        
        int d = digits.charAt(pos) - '0';
        String s = map[d];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            helper(ret, sb, pos + 1, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    } 
    
    
}


public class LetterCombinations {
    
    private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return ret;
        }
        
        ret.add("");
        
        for (int i = 0; i < digits.length(); i++) {
            
            List<String> tmp = new ArrayList<String>();
            int cur = digits.charAt(i) - '0';
            String s = map[cur];
            for (int j = 0; j < s.length(); j++) {
                for (int k = 0; k < ret.size(); k++) {
                    tmp.add(ret.get(k) + s.charAt(j));
                }
            }
            
            ret = tmp;
        }
        return ret;
    }
    
    
}
