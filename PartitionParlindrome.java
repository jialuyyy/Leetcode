class Solution {
    public List<List<String>> PartitionParlindrome(String s) {
        List<List<String>> ret = new ArrayList<>();
        if (s == null || s.length() == 0)
            return ret;
        
        helper(new ArrayList<String>(), ret, 0, s);
        return ret;
    }
    
    private void helper(List<String> list, List<List<String>> ret, int index, String s) {
        if (index == s.length()) {
            ret.add(new ArrayList<String>(list));
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                list.add(s.substring(index, i + 1));
                helper(list, ret, i + 1, s);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            
            start++;
            end--;
        }
        
        return true;
    }
}
