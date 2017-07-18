//Time Complexity analysis
//get(int key):queue.remove(cacheNode) needs O(n), n is the size of the queue, but for map retrieval is O(1)
//put(int key, int value): O(n) time to do the removal and O(1) time to update the frequency hashmap and keyValue hashMap

//should use treemap instead, as for treepmap the removal operation only takes O(log(capacity)) time.
public class LFUCache {
    private int capacity;
    private Queue<CacheNode> queue = null;
    //maintain the key-value pair
    private Map<Integer, Integer> keyValueMap = null;
    //maintain the key-frequency pair
    private Map<Integer, Integer> frequencyMap = null;
    private int id = 0;
    class CacheNode {
        int key;
        int freq;
        int recentness;
        
        public CacheNode(int key, int freq, int recentness) {
            this.key = key;
            this.freq = freq;
            this.recentness = recentness;
        }
        
        //override the equals() and hashCode() method, to do the remove in the priority queue
        
        public boolean equals(Object object) {return key==((CacheNode) object).key;}
        public int hashCode() {return key;}
        
    }
    public LFUCache(int capacity) {
        this.capacity = capacity;
        
        //in the priority queue, all of the cache node are sorted based on the frequency first
        //and if there is a tie in the frequency, then it will be sorted based on the recentness
        //for the recentness, we use a global variable recent to record, every time increase the id value
        //when doing the get or set
        this.queue = new PriorityQueue<CacheNode>(10, new Comparator<CacheNode>(){
            public int compare(CacheNode n1, CacheNode n2) {
                if (n1.freq == n2.freq) {
                    return n1.recentness - n2.recentness;
                }
                
                return n1.freq - n2.freq;
            }
            
            
        });
        
        //initialize two hashmaps
        this.keyValueMap = new HashMap<Integer, Integer>();
        this.frequencyMap = new HashMap<Integer, Integer>();
    }
    
    //if the keyValueMap contains key
    //update the frequency and the recentness and reput it in the priority queue
    //else, return -1
    public int get(int key) {
        id++;
        if (this.keyValueMap.containsKey(key)) {
            update(key);
            
            return this.keyValueMap.get(key);
        }
        
        return -1;
    }
    
    //if the keyValueMap contains the key, update the current keyValueMap and update the frequencyMap and the queue
    //if reaches the capacity, remove the least frequently used one from all of the three data structures
    //create a new CacheNode and insert it into the priorityQueue, and add the key-value pair into the frequency map and the 
    //keyValueMap
    public void put(int key, int value) {
        if (this.capacity == 0) {
            return;
        }
        id++;
        if (this.keyValueMap.containsKey(key)) {
            update(key);
            keyValueMap.put(key, value);
            
            return;
        }
        
        if (keyValueMap.size() == this.capacity) {
            CacheNode cur = queue.poll();
            keyValueMap.remove(cur.key);
            frequencyMap.remove(cur.key);
        }
        
        frequencyMap.put(key, 1);
        keyValueMap.put(key, value);
        CacheNode node = new CacheNode(key, 1, id);
        queue.offer(node);
    }
    
    private void update(int key) {
        //update the frequency
        int f = frequencyMap.get(key) + 1;
        frequencyMap.put(key, f);
        
        //create a new cache node with the new frequency and the recentness, the larger the id is, the larger the recentness
        CacheNode cache = new CacheNode(key, f, id);
        
        //remove the current cache node in the queue and offer the new node
        queue.remove(cache);
        queue.offer(cache);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

//TreeSet implements comparable to compare the values in it, so need to use a hashmap that key-value pair is key and cachenode to retrieve the 
//node in treenode
//the remove time complexity here is O(log(n)) n is the capacity of the map
public class LFUCache {
    private int capacity;
    private TreeSet<CacheNode> treeSet = null;
    //maintain the key-value pair
    private Map<Integer, Integer> keyValueMap = null;
    //maintain the key-cacheNode pair
    private Map<Integer, CacheNode> cacheMap = null;
    private int id = 0;
    class CacheNode implements Comparable<CacheNode>{
        int key;
        int freq;
        int recentness;
        
        public CacheNode(int key, int freq, int recentness) {
            this.key = key;
            this.freq = freq;
            this.recentness = recentness;
        }
        
        //override the compareTo() method in the Comparable interface to do the comparison for the cache node
        //if the key is the same, they are equal, else, compare the frequency, if the frequency is the same, compare the 
        //recentness.
        public int compareTo(CacheNode o) {return key == o.key? 0 : freq == o.freq ? recentness - o.recentness:freq - o.freq;}
        
    }
    public LFUCache(int capacity) {
        this.capacity = capacity;
        
        //treeset implements compareTo methods
        this.treeSet = new TreeSet<CacheNode>();
        
        //initialize two hashmaps
        this.keyValueMap = new HashMap<Integer, Integer>();
        this.cacheMap = new HashMap<Integer, CacheNode>();
    }
    
    //if the keyValueMap contains key
    //update the frequency and the recentness and reput it in the priority queue
    //else, return -1
    public int get(int key) {
        id++;
        if (this.keyValueMap.containsKey(key)) {
            update(key);
            
            return this.keyValueMap.get(key);
        }
        
        return -1;
    }
    
    //if the keyValueMap contains the key, update the current keyValueMap and update the frequencyMap and the queue
    //if reaches the capacity, remove the least frequently used one from all of the three data structures
    //create a new CacheNode and insert it into the priorityQueue, and add the key-value pair into the frequency map and the 
    //keyValueMap
    public void put(int key, int value) {
        if (this.capacity == 0) {
            return;
        }
        id++;
        if (this.keyValueMap.containsKey(key)) {
            update(key);
            keyValueMap.put(key, value);
            
            return;
        }
        
        if (keyValueMap.size() == this.capacity) {
            CacheNode cur = treeSet.pollFirst();
            keyValueMap.remove(cur.key);
            cacheMap.remove(cur.key);
        }
        
        
        keyValueMap.put(key, value);
        CacheNode node = new CacheNode(key, 1, id);
        cacheMap.put(key, node);
        treeSet.add(node);
    }
    
    private void update(int key) {
        //update the frequency
        int f = cacheMap.get(key).freq + 1;
        treeSet.remove(cacheMap.get(key));
        
        //create a new cache node with the new frequency and the recentness, the larger the id is, the larger the recentness
        CacheNode cache = new CacheNode(key, f, id);
        cacheMap.put(key, cache);
        //remove the current cache node in the treeset and offer the new node
        treeSet.add(cache);
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
