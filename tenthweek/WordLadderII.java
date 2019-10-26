class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ret = new ArrayList<>();
        //keep the mapping between the word and its distance to the begin word
        Map<String, Integer> distance = new HashMap<>();
        
        //keep the mapping between the word and its neighbors
        Map<String, Set<String>> neighbors = new HashMap<>();
        
        //move the words from wordlist to set to decrease time complexity
        Set<String> dictionary = new HashSet<>(wordList);
        
        //bfs using the queue
        Deque<String> queue = new ArrayDeque<>();
        
        distance.put(beginWord, 1);
        queue.offer(beginWord);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                Set<String> candidates = getNeighbors(curWord, dictionary);
                Set<String> removed = new HashSet<String>();
                for (String candidate : candidates) {
                    if (!distance.containsKey(candidate)) {
                        distance.put(candidate, distance.get(curWord) + 1);
                        queue.offer(candidate);
                    } else {
                        //output : [["hit","hot","lot","log","cog"]
                        //expected : [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
                        
                        //because cog will be removed when dog is curword, if we 
                        //dont have this check, and the result will be incomplete
                        if (distance.get(candidate) < distance.get(curWord) + 1)
                            removed.add(candidate);
                    }
                }
                
                for (String remove : removed) {
                    candidates.remove(remove);
                }
                
                neighbors.put(curWord, candidates);
            }
        }
        dfs(beginWord, endWord, neighbors, new ArrayList<String>(), ret);
        
        return ret;
        
    }
    
    private void dfs(String beginWord, String endWord, Map<String, Set<String>> neighbors, List<String> list, List<List<String>> ret) {
        if (beginWord.equals(endWord)) {
            list.add(endWord);
            ret.add(new ArrayList<String>(list));
            list.remove(list.size() - 1);
            return;
        }
        
        list.add(beginWord);
        
        if (neighbors.get(beginWord) != null) {
            for (String neighbor : neighbors.get(beginWord)) {
                dfs(neighbor, endWord, neighbors, list, ret);
            }
        }
        
        
        list.remove(list.size() - 1);
    }
    
    private Set<String> getNeighbors(String word, Set<String> dictionary) {
        //hit
        char[] ch = word.toCharArray();
        Set<String> neighbors = new HashSet<>();
        for (int i = 0; i < ch.length; i++) {
            char cur = ch[i];
            for (char c = 'a'; c <= 'z'; c++) {
                ch[i] = c;
                
                if (dictionary.contains(String.valueOf(ch)) && !word.equals(String.valueOf(ch))) {
                    neighbors.add(String.valueOf(ch));
                }
            }
            //change the character back;
            ch[i] = cur;
        }
        
        return neighbors;
    }
}
