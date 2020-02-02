class FirstUniqChar {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0)
            return -1;
        
        Map<Character, Integer> count = new HashMap<>();
        
        //O(l) l is the length of string s
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        //O(l) l is the length of string s
        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
