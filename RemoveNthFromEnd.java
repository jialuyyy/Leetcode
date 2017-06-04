/*Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.*/

//beats 0.92%
//one pass solution: fast pointer move n steps in advance than slow pointer. 
//Time Complexity: O(n)
//Space Complexity: O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }
}

//updates: cleaner and shorter one
//beats: 30.55%
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode slow = head;
        ListNode fast = head;
        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }
        
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return head;
    }
}
