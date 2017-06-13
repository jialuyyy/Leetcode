//beats 16.20%
//Time Complexity: O(n)
//Space Complexity: O(n)
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> hashMap = new HashMap<RandomListNode, RandomListNode>();
        if (head == null) {
            return head;
        }
        
        RandomListNode tmp = head;
        while (tmp != null) {
            if (hashMap.get(tmp) == null) {
                RandomListNode copy = new RandomListNode(tmp.label);
                hashMap.put(tmp, copy);
            }
            
            RandomListNode next = tmp.next;
            RandomListNode random = tmp.random;
            
            if (next != null && hashMap.get(next) == null) {
                RandomListNode copyNext = new RandomListNode(next.label);
                hashMap.put(next, copyNext);
            }
            
            if (random != null && hashMap.get(random) == null) {
                RandomListNode copyRandom = new RandomListNode(random.label);
                hashMap.put(random, copyRandom);
            }
            
            
            hashMap.get(tmp).next = hashMap.get(next);
            hashMap.get(tmp).random = hashMap.get(random);
            
            tmp = tmp.next;
        }
        
        return hashMap.get(head);
    }
}



//in place solution, no need to use hashmap
//beats 72.16%
//Time Complexity: O(n) three passes
//Space Complexity: O(n)
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode tmp = head;
        
        //copy the label of each node and connect the copied node right after the original one
        //the first pass
        while (tmp != null) {
            RandomListNode copy = new RandomListNode(tmp.label);
            copy.next = tmp.next;
            tmp.next = copy;
            tmp = tmp.next.next;
        }
        
        
        tmp = head;
        //the second pass
        //copy random
        while (tmp != null) {
            if (tmp.random != null) {
                tmp.next.random = tmp.random.next;
            }
            tmp = tmp.next.next;
        }
        
        
        tmp = head;
        //third pass
        //split the list
        RandomListNode copyHead = tmp.next;
        while (tmp != null) {
            RandomListNode cur = tmp.next;
            tmp.next = cur.next;
            if (cur.next != null)
                cur.next = cur.next.next;
            
            tmp = tmp.next;
        }
        
        return copyHead;
    }
}
