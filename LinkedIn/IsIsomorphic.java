public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Character> mapping1 = new HashMap<Character, Character>();
        
        
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            if (mapping1.get(c1) == null) {
                if (mapping1.containsValue(c2)) {
                    return false;
                } 
                mapping1.put(c1, c2);
            } else {
                if (mapping1.get(c1) != c2) {
                    return false;
                }
            }
            
           
        }
        
        return true;
    }
}
