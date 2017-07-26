//iterate over the whole string array to locate the word1, and expand from the word1 to find the word2,
//every time update the current minimum distance.

public class ShortestDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0 || word1 == null || word2 == null) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                min = Math.min(expand(word2, i, words), min);
            }
        }
        
        return min;
    }
    
    public int expand(String word2, int i, String[] words) {
        for (int j = 1; j < words.length; j++) {
            int index1 = i + j;
            int index2 = i - j;
            
            if (index1 < words.length) {
                if (word2.equals(words[index1])) {
                    return j;
                }
            }
            
            if (index2 >= 0) {
                if (word2.equals(words[index2])) {
                    return j;
                }
            }
        }
        
        return 0;
    }
}
