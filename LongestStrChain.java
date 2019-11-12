//"a" "b" "ba" "bca" "bda" "bdca"

//key is the word, value is the longest length of string chain ending with this word
//"a" 1
//"b" 1
// "ba" 2
// "bca" 3
//"bda"  3
//"bdca" 4
class LongestStrChain {
    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        
        //sort the words based on the length of the words
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        Map<String, Integer> dp = new HashMap<>();
        int rest = 1;
        for (String word : words) {
            
            int best = 0;
            for (int i = 0; i < word.length(); i++) {
                String cur = word.substring(0, i) + word.substring(i + 1);
                
                best = Math.max(best, dp.getOrDefault(cur, 0) + 1);
            }
            //put the word with its longest length of string chain
            dp.put(word, best);
            //update the current rest
            rest = Math.max(rest, best);
         }
        
        return rest;
    }
}
