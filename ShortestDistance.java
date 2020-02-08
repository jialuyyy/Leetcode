class ShortestDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length < 2)
            return -1;
        
        int index1 = -1;
        int index2 = -1;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                index1 = i;
            }
            
            if (word2.equals(words[i])) {
                index2 = i;
            }
            
            if (index1 != -1 && index2 != -1) {
                min = Math.min(min, Math.abs(index1 - index2));
            }
        }
        
        return min;
    }
}
