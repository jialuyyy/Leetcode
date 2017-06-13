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
