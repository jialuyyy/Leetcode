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

class ValidWordAbbr {
    //map to keep abbreviation and a set of the words has the abbreviation
    Map<String, Integer> countAbbr = null;
    Map<String, Integer> countWord = null;
    public ValidWordAbbr(String[] dictionary) {
        countAbbr = new HashMap<>();
        countWord = new HashMap<>();
        for (String word : dictionary) {
            String abbr = "";
            if (word.length() <= 2) {
                abbr = word;
            } else {
                abbr = "" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
            }
            
            countAbbr.put(abbr, countAbbr.getOrDefault(abbr, 0) + 1);
            countWord.put(word, countWord.getOrDefault(word, 0) + 1);
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = "";
        if (word.length() <= 2) {
            abbr = word;
        } else {
            abbr = "" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
        }
            
        return countAbbr.get(abbr) == countWord.get(word);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
