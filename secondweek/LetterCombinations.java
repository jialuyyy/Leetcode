//beats 23%
//Time Complexity: O(k ^ n)
//k is the average length of each strings in the map and the n is the digits length.

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return ret;
        }
        
        String[] map = {"", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ret.add("");
        for (int i = 0; i < digits.length(); i++) {
            int ch = digits.charAt(i) - '0';
            String cur = map[ch];
            
            List<String> tmp = new ArrayList<String>();
            for (int j = 0; j < cur.length(); j++) {
                for (int k = 0; k < ret.size(); k++) {
                    tmp.add(ret.get(k) + cur.charAt(j));
                }
            }
            ret = tmp;
        }
        
        return ret;
    }
}


//beats 47.22%
//recursive solution reading from the leetcode discussion
public class Solution {
    private static final String[] KEYS = {"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return ret;
        }
        
        helper("", digits, 0, ret);
        
        return ret;
    }
    
    
    private void helper(String prefix, String digits, int offset, List<String> ret) {
        if (digits.length() == offset) {
            ret.add(prefix);
            return;
        }
        
       
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            helper(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
        
    }
    
    
}
