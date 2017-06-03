//thoughts: two pointers - prev pointer used to connect to the different values; cur pointer used to iterate over the list
//Time Complexity: O(n)
//beats 17.80%
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = head;
        ListNode cur = head.next;
        
        while (cur != null) {
            if (cur.val != prev.val) {
                prev.next = cur;
                prev = cur;
            } 
                
            cur = cur.next;
            
        }
        prev.next = null;
        
        return head;
    }
}
