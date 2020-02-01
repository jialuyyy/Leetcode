class topKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ret = new ArrayList<>();
        if (words == null || words.length == 0)
            return ret;
        
        //O(n) time
        //O(n) space
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        
        //min heap k size
        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e1.getValue() == e2.getValue() ? e2.getKey().compareTo(e1.getKey()) : e1.getValue() - e2.getValue();
            }
        });
        
        for (Map.Entry<String, Integer> entry: frequency.entrySet()) {
            if (pq.size() < k) {
                pq.offer(entry);
            } else {
                if (pq.peek().getValue() <= entry.getValue()) {
                    pq.offer(entry);
                    pq.poll();
                }
            }
        }
        
        while(!pq.isEmpty()) {
            ret.add(pq.poll().getKey());
        }
        
        Collections.reverse(ret);
        return ret;
    }
}

//just need to store strings int priority queue, no need to store entry
//maintain a min heap and the small frequency will be before the larger frequency and when the frequency of two words equal ,
//we put the larger words before the smaller workds
//at the end, reverse the order
class topKFrequentWord {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ret = new ArrayList<>();
        if (words == null || words.length == 0)
            return ret;
        
        //O(n) time
        //O(n) space
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        
        //min heap k size 
        Queue<String> pq = new PriorityQueue<>(new Comparator<String>(){
            public int compare(String s1, String s2) {
                return frequency.get(s1) == frequency.get(s2) ? s2.compareTo(s1) : frequency.get(s1) - frequency.get(s2) ;
            }
        });
        
        for (String word : frequency.keySet()) {
            pq.offer(word);
            //minheap, the smallest will get out
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        while(!pq.isEmpty()) {
            ret.add(pq.poll());
        }
        
        Collections.reverse(ret);
        return ret;
    }
}
