//One time pass, reverse part of the linked list between m to n
//Time Complexity: O(n)
//beats: 18.48%
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        int tmp = m;
        while (tmp > 1) {
            p = p.next;
            tmp--;
        }
        
        p.next = reverse(p.next, m , n);
        return dummy.next;
    }
    
    private ListNode reverse(ListNode node, int m, int n) {
        int count = n - m + 1;
        ListNode p = node;
        ListNode newHead = null;
        while (count > 0) {
            ListNode tmp = p.next;
            p.next = newHead;
            newHead = p;
            p = tmp;
            count--;
        }
        node.next = p;
        return newHead;
    }
}
