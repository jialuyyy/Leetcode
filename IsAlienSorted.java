//use an array to store the sequence index of the 26 characters
//"hlabcdefgijkmnopqrstuvwxyz"
// a -> 2   b -> 3
// 2 3 4 5 6 7 8 0 9 10 11 1 12 13 14 15 16 17 18 19 20 21 22 23 24 25 
//compare ajacent words to find the first different character
//and find the index for the character in the hash table
//if the left character's index > right character's index
//return false
class IsAlienSorted {
    public boolean isAlienSorted(String[] words, String order) {
        int[] indexTable = new int[26];
        
        for (int i = 0; i < order.length(); i++) {
            indexTable[order.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int j = 0;
            for (; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (indexTable[word1.charAt(j) - 'a'] > indexTable[word2.charAt(j) - 'a']) {
                        return false;
                    }
                    break;
                }
            }
            
            //handle case app/apple, blank is less than all of the characters
            if (j == Math.min(word1.length(), word2.length()) && word1.length() > word2.length())
                return false;
        }
        
        return true;
        
    }
}
