class MyHashMap {

    /** Initialize your data structure here. */
    class ListNode {
        int key;
        int val;
        ListNode next;
        
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    ListNode[] listNodes = null;
    public MyHashMap() {
        listNodes = new ListNode[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = idx(key);
        if (listNodes[index] == null) {
            listNodes[index] = new ListNode(-1, -1);
        }
        
        ListNode prevNode = find(listNodes[index], key);
        if (prevNode.next == null) {
            prevNode.next = new ListNode(key, value);
        } else {
            prevNode.next.val = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    private int idx(int key) {
        return Integer.hashCode(key) % listNodes.length;
    }
    
    private ListNode find(ListNode listNode, int key) {
        ListNode prevNode = null;
        
        while (listNode != null && key != listNode.key) {
            prevNode = listNode;
            listNode = listNode.next;
        }
        
        return prevNode;
    }
    public int get(int key) {
        int index = idx(key);
        if (listNodes[index] == null) {
            return -1;
        }
        
        ListNode prevNode = find(listNodes[index], key);
        if (prevNode.next == null) {
            return -1;
        } else {
            return prevNode.next.val;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = idx(key);
        if (listNodes[index] == null) {
            return;
        }
        
        ListNode prevNode = find(listNodes[index], key);
        if (prevNode.next == null) {
            return;
        } else {
            prevNode.next = prevNode.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
