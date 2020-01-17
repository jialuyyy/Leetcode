class IsStrobogrammatic {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put('1', '1');
        mapping.put('0', '0');
        mapping.put('6', '9');
        mapping.put('9', '6');
        mapping.put('8', '8');
        
        int start = 0;
        int end = num.length() - 1;
        
        while (start <= end) {
            char ch1 = num.charAt(start);
            char ch2 = num.charAt(end);
            
            if (mapping.get(ch1) == null || mapping.get(ch2) == null)
                return false;
            
            if (mapping.get(ch1) != ch2) {
                return false;
            }
            
            start++;
            end--;
        }
        
        
        return true;
    }
}
