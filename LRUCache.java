/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?*/

//Time Complexity: O(1)
//beats 58.09%
//Double linked list: used to maintain the cache. The most recently used node will be move to the last; if the capacity is reached,
//remove the first node in the list and insert the new one to the tail. use two dummy node - head and tail to do insertion and deletion
//more conveniently.

//HashMap: maintain the <key, doublelinkednode> pair, as hashMap is able to get the value of a key in O(1) time complexity.

public class LRUCache {
    
    class DoubleLinkedNode {
        int key;
        int val;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;
        
        public DoubleLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private Map<Integer, DoubleLinkedNode> hashMap = null;
    private DoubleLinkedNode head = new DoubleLinkedNode(-1, -1);
    private DoubleLinkedNode tail = new DoubleLinkedNode(-1, -1);
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.hashMap = new HashMap<Integer, DoubleLinkedNode>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (hashMap.get(key) != null) {
            moveToLast(hashMap.get(key));
            return hashMap.get(key).val;
        }
        else 
            return -1;
    }
    
    public void put(int key, int value) {
       if (hashMap.containsKey(key)) {
           DoubleLinkedNode node = hashMap.get(key);
           node.val = value;
           moveToLast(node);
       } else {
           if (hashMap.size() == this.capacity) {
               removeHead();
           } 
           
           insertLast(key, value);
       }
    }
    
    private void moveToLast(DoubleLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        tail.prev.next = node;
        node.prev = tail.prev;
        
        node.next = tail;
        tail.prev = node;
    }
    
    private void removeHead() {
        int key = head.next.key;
        head.next = head.next.next;
        head.next.prev = head;
        hashMap.remove(key);
    }
    
    private void insertLast(int key, int value) {
        DoubleLinkedNode node = new DoubleLinkedNode(key, value);
        hashMap.put(key, node);
        
        tail.prev.next = node;
        node.prev = tail.prev;
        
        node.next = tail;
        tail.prev = node;
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
