//beats 83.31%
//iterate over the while linked list and keep two pointers to the first list node and second list node, every time 
//update the current node
//Time complexity: O(n)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode cur = dummy;
        
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            
            first.next = second.next;
            second.next = first;
            cur.next = second;
            cur = cur.next.next;
        }
        
        return dummy.next;
    }
}

//recursion
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode node = head.next;
        head.next = swapPairs(node.next);
        node.next = head;
        
        return node;
    }
    
    //1->2->3->4
    
    

}
