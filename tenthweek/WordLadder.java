//TLE
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0 || beginWord == null || endWord == null || beginWord.length() != endWord.length())
            return 0;
        
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }
        
        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        
        int len = 1;
        
        while (!q.isEmpty() && dict.size() > 0) {
            int size = q.size();
            len++;
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                List<String> list = getList(cur, dict);
                
                for (String s: list) {
                    if (s.equals(endWord)) {
                        return len;
                    } 
                    
                    q.offer(s);
                    dict.remove(s);
                }
            }
        }
        
        return 0;
    }
    
    private List<String> getList(String cur, Set<String> dict) {
        
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < cur.length(); i++) {
            char[] ch = cur.toCharArray();
            for (char j = 'a'; j <= 'z'; j++) {
                if (ch[i] == j)
                    continue;
                ch[i] = j;
                if (dict.contains(String.valueOf(ch))) {
                    list.add(String.valueOf(ch));
                }
            }
        }
        
        return list;
    }
}
