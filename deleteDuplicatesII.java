/*Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// thoughts: two pointers, prev pointer to do the connection and cur pointer to iterate over the linkedlist
// 1. if cur.val == cur.next.val, move cur to the next node
// 2. if pre.next == cur, move prev to the next node
// 3. if pre.next != cur, which means cur node val has duplicates, so connect the cur.next to pre.next.
// beats 6.25%
// Time complexity: O(n)

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode cur = dummy.next;
        
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            
            if (prev.next == cur) {
                prev = prev.next;
            } else {
                prev.next = cur.next;
            }
            cur = cur.next;
        }
        
        return dummy.next;
    }
}
