/*All O`one Data Structure
Implement a data structure supporting the following operations:

Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
Challenge: Perform all these in O(1) time complexity.*/

class AllOne {
    //each bucket stores all the keys with the same count
    class Bucket {
        Bucket next;
        Bucket prev;
        Set<String> keySet;
        int count;
        
        public Bucket(int count) {
            this.count = count;
            this.keySet = new HashSet<>();
        }
    }
    /** Initialize your data structure here. */
    //build map between key and count
    Map<String, Integer> keyCountMap;
    
    //build map between count and the bucket
    Map<Integer, Bucket> countBucketMap;
    Bucket head;
    Bucket tail;
    public AllOne() {
        keyCountMap = new HashMap<>();
        countBucketMap = new HashMap<>();
        //the head bucket keeps track of the smallest key
        head = new Bucket(Integer.MIN_VALUE);
        //the tail bucket keeps track of the highest key
        tail = new Bucket(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (keyCountMap.containsKey(key)) {
            changeKey(key, 1);
        } else {
            keyCountMap.put(key, 1);
            Bucket curBucket = countBucketMap.get(1);
            if (curBucket == null) {
                createNewBucketAfter(1, head);
                head.next.keySet.add(key);
            } else {
                curBucket.keySet.add(key);
            }
        }
    }
    
    
    private void createNewBucketAfter(int count, Bucket bucket) {
        Bucket newBucket = new Bucket(count);
        countBucketMap.put(count, newBucket);
        newBucket.next = bucket.next;
        bucket.next.prev = newBucket;
        bucket.next = newBucket;
        newBucket.prev = bucket;
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (keyCountMap.containsKey(key)) {
            if (keyCountMap.get(key) != 1)
                changeKey(key, -1);
            else {
                int count = keyCountMap.get(key);
                keyCountMap.remove(key);
                
                Bucket curBucket = countBucketMap.get(count);
                
                if (curBucket.keySet.size() == 1) {
                    removeBucket(curBucket);
                    countBucketMap.remove(count);
                } else {
                    curBucket.keySet.remove(key);
                }
                
            }
         } 
    }
    
    private void changeKey(String key, int offset) {
        int count = keyCountMap.get(key);
        Bucket curBucket = countBucketMap.get(count);
        
        Bucket bucket = countBucketMap.get(count + offset);
        if (bucket == null) {
            createNewBucketAfter(count + offset, offset == 1 ? curBucket : curBucket.prev);
        }
        
        if (curBucket.keySet.size() == 1) {
            removeBucket(curBucket);
            countBucketMap.remove(count);
        } else {
            curBucket.keySet.remove(key);
        }
        countBucketMap.get(count + offset).keySet.add(key);
        keyCountMap.put(key, keyCountMap.get(key) + offset);
    }
    
    private void removeBucket(Bucket b) {
        b.prev.next = b.next;
        b.next.prev = b.prev;
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keySet.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keySet.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
