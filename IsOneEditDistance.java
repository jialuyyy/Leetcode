//1. make sure s is shorter than t, if not, swap s and t
//2. if the difference of length of s and length of t is bigger than 1, return false
//3. compare, find the pos that s and t have different character
//     same length ---> abxcd and abycd  check if the substring from i + 1 is the same
//     diff length ---> abcd and abxcd check if substring from i is the same as substring from i + 1
class IsOneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int ns = s.length();
        int nt = t.length();
        
        if (ns > nt) {
            return isOneEditDistance(t, s);
        }
        
        if (nt - ns > 1) {
            return false;
        }
        
        for (int i = 0; i < ns; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (ns == nt)
                    return s.substring(i + 1).equals(t.substring(i + 1));
                
                else
                    return s.substring(i).equals(t.substring(i + 1));
            }
        }
        
        return ns + 1 == nt;
    }
}
