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

//data structure used:
//1. keyValueMap is used to maintain the key value pair
//2. keyNodeMap is used to maintain the key with its corresponding node in the doubly linked list
//3. doublylinked list is used to maintain the frequency of the each key, in each node, keep, the frequency, key and a linkedhashset
//why use linkedHashSet?
// for the situation when there are multiple keys with the least frequency when doing
//the remove, linkedhashset keeps the sequence of insertion, so the oldest one will be at the front of the linked hashset 

//get(key)
//1. if the key exist, get the value from the keyvaluemap and increase the freqency in the doubly linked list
//2. otherwise, return -1;

//put(key, value)
//1. if the key exist, override the value in the keyValueHashmap and increase the frequency in the doubly linkedlist
//2. If not
//    1. if reaches capacity, remove the old ones first and add the new one, should add it to the head of the doubly 
//    linked list and then increase the frequency
//    2. simply add the new one, should add it to the head of the doubly linked list and then increase the frequency



//increase Frequency(key)

//remove the key from the keyNodehashMap first
//add the key to the currentCount + 1' s node in the doubly linked list
//update the keyNode hash
//if the head's keyset is empty, remove the head node


//Time Complexity:

//get(key:O(1)

//put(key, value) :O(1)
public class LFUCache {
    class Node {
        //the used frequency
        int count;
        int key;
        //in sequence, use linkedhashset, for the situation when there are multiple keys with the least frequency when doing
        //the remove, linkedhashset keeps the sequence of insertion, so the oldest one will be at the front of the linked hashset
        LinkedHashSet<Integer> keySet = null;
        Node prev = null;
        Node next = null;
        
        public Node (int count) {
            this.count = count;
            this.keySet = new LinkedHashSet<Integer>();
        }
        
    }
    private int capacity;
    private Node head = null;
    private Map<Integer, Integer> keyValueHash = null;
    private Map<Integer, Node> keyNodeHash = null;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.keyValueHash = new HashMap<Integer, Integer>();
        this.keyNodeHash = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if (keyValueHash.containsKey(key)) {
            increaseFreq(key);
            
            return keyValueHash.get(key);
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        if (this.capacity == 0) {
            return;
        }
        
        if (keyValueHash.containsKey(key)) {
            //update the keyValueHash
            keyValueHash.put(key, value);
        } else {
            //reach capacity
            if (this.capacity == keyValueHash.size()) {
                //remove the least frequently used one
                removeOld();
                keyValueHash.put(key, value);
            } else {
                keyValueHash.put(key, value);
            }
            
            //add the new node into the doubly linked list
            addToHead(key);
        }
        
        //increaseFreq
        increaseFreq(key);
    }
    
    private void addToHead(int key) {
        if (head == null) {
            head = new Node(0);
            head.keySet.add(key);
        } else if (head.count > 0) {
            Node node = new Node(0);
            node.keySet.add(key);
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            head.keySet.add(key);
        }
        
        keyNodeHash.put(key, head);
    }
    
    private void increaseFreq(int key) {
        //get the node from the keyNodehash, and remove it from the current keyset
        Node node = keyNodeHash.get(key);
        node.keySet.remove(key);
        
        if (node.next == null) {
            node.next = new Node(node.count + 1);
            node.next.prev = node;
            node.next.keySet.add(key);
        } else if (node.next.count == node.count + 1) {
            node.next.keySet.add(key);
        } else {
            Node n = new Node(node.count + 1);
            n.keySet.add(key);
            n.prev = node;
            n.next = node.next;
            node.next = n;
            n.next.prev = n;
        }
        
        keyNodeHash.put(key, node.next);
        
        if (node.keySet.size()== 0) {
            remove(node);
        }
        
    }
    
    private void removeOld() {
        if (head == null)
            return;
        
        int index = 0;
        
        for (int k: head.keySet) {
            index = k;
            break;
        }
        
        head.keySet.remove(index);
        if (head.keySet.size() == 0) {
            remove(head);
        }
        
        keyNodeHash.remove(index);
        keyValueHash.remove(index);
    }
    
    private void remove(Node n) {
        if (n.prev == null) {
            head = n.next;
        } else {
            n.prev.next = n.next;
        }
        
        if (n.next != null) {
            n.next.prev = n.prev;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
