class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || abbr == null)
            return false;
        int i = 0;
        int j = 0;
        
        char[] s = word.toCharArray();
        char[] t = abbr.toCharArray();
        
        while (i < s.length && j < t.length) {
            
            if (Character.isDigit(t[j])) {
                if (t[j] == '0')
                    return false;
                int val = 0;
                while (j < t.length && Character.isDigit(t[j])) {
                    val = val * 10 + t[j] - '0';
                    j++;
                }
                i += val;
            } else {
                if (s[i] != t[j]) {
                    return false;
                }
                i++;
                j++;
            }
        }
        
        return i == s.length && j == t.length;
    }
}
