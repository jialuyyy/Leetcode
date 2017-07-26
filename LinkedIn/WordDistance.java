//pre keep the words in a hashmap, key will be the string word and the value will be the list of the index
//so if someone called the shortest many times with different parameters in it, it will just get the index list of the specific word via O(1)
//by checking the hashmap and no need to iterate over the whole string word array every time

public class WordDistance {
    private Map<String, List<Integer>> map = null;
    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            if (map.get(words[i]) == null) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i], list);
            } else {
                map.get(words[i]).add(i);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        if (list1.size() == 1 && list2.size() == 1) {
            return Math.abs(list1.get(0) - list2.get(0));
        } else {
            for (int i = 0; i < list1.size(); i++) {
                for (int j = 0; j < list2.size(); j++) {
                    min = Math.min(min, Math.abs(list1.get(i) - list2.get(j)));
                }
            }
        }
        
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
