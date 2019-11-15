class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> ret = new ArrayList<>();
        if(s == null || p == null || s.length() < p.length())
            return ret;
        
        int[] map = new int[256];
        for (char c : p.toCharArray())
            map[c]++;
        
        int start = 0;
        int end = 0;
        int count = p.length();
        
        while (end < s.length()) {
            
            if (map[s.charAt(end++)]-- > 0)
                count--;
            
            if (count == 0)
                ret.add(start);
            
            if (end - start == p.length() && map[s.charAt(start++)]++ >= 0)
                count++;
        }
        
        return ret;
    }
}
