class ValidWordAbbr {
    Map<String, Set<String>> map = null;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String s : dictionary) {
            String abbr = "";
            if (s.length() <= 2) {
                abbr = s;
                break;
            }
            int first = s.charAt(0);
            int last = s.charAt(s.length() - 1);
            
            int middle = s.length() - 2;
            abbr = first + String.valueOf(middle) + last;
            
            
            if (!map.containsKey(abbr)) {
                Set<String> set = new HashSet<>();
                map.put(abbr, set);
            }
            map.get(abbr).add(s);
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = "";
        if (word.length() <= 2) {
            abbr = word;
        } else {
            int first = word.charAt(0);
            int last = word.charAt(word.length() - 1);
            
            int middle = word.length() - 2;
            abbr = first + String.valueOf(middle) + last;
        }
        
        return map.get(abbr) == null || map.get(abbr).contains(word) && map.get(abbr).size() < 2;
            
        
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
