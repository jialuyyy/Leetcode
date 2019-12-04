/*Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.*/
class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return ret;
        int wordLen = words[0].length();
        int number = words.length;
        int sLen = s.length();
        
        Map<String, Integer> counts = new HashMap<>();
        
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i < s.length() - wordLen * number + 1; i++) {
            String substring = s.substring(i, i + number * wordLen);
            if (isConcat(substring, counts, wordLen))
                ret.add(i);
        }
        
        return ret;
    }
    
    
    private boolean isConcat(String substring, Map<String, Integer> counts, int wordLen) {
        Map<String, Integer> seen = new HashMap<>();
        for (int i = 0; i < substring.length(); i += wordLen) {
            String cur = substring.substring(i, i + wordLen);
            seen.put(cur, seen.getOrDefault(cur, 0) + 1);
        }
        
        return seen.equals(counts);
    }
}
