class WordsAbbreviation {
    public List<String> wordsAbbreviation(List<String> dict) {
        if (dict == null || dict.size() == 0)
            return new ArrayList<>();
        
        List<String> ret = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        int round = 1;
        for (String word : dict) {
            String abbr = getAbbr(word, round);
            ret.add(abbr);
            
            count.put(abbr, count.getOrDefault(abbr, 0) + 1);
        }
        
        while (true) {
            boolean unique = true;
            round++;
            for (int i = 0; i < ret.size(); i++) {
                if (count.get(ret.get(i)) > 1) {
                    String abbr = getAbbr(dict.get(i), round);
                    ret.set(i, abbr);
                    count.put(abbr, count.getOrDefault(abbr, 0) + 1);
                    unique = false;
                }
            }
            
            if (unique)
                break;
        }
        
        return ret;
        
        
    }
    
    //prefix number
    private String getAbbr(String s, int p) {
        if (p + 2 >= s.length()) {
            return s;
        }
        
        String ans;
        
        ans = s.substring(0, p) + (s.length() - 1 - p) + s.charAt(s.length() - 1);
        
        return ans;
    }
}
