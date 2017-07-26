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

//one pass solution
//iterate over the array, to check whether current word equals to word1 or word2, update the index if equaling.
//if p1 != -1 and p2 != -1, update the minimum value

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0 || word1 == null || word2 == null) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int p1 = -1;
        int p2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
            }
            
            if (words[i].equals(word2)) {
                p2 = i;
            }
            
            if (p1 != -1 && p2 != -1) {
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }
        
        return min;
    }
}


//more concise one
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0 || word1 == null || word2 == null) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (index != -1 && !words[index].equals(words[i])) {
                    min = Math.min(min, i - index);
                }
                index = i;
            }
        }
        
        return min;
    }
}
