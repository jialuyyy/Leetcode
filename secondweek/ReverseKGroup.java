//Beats 3.22%

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        
        while (p != null) {
            ListNode tmp = p.next;
            p.next = reverse(p.next, k);
            p = tmp;
        }
        
        return dummy.next;
    }
    
    private ListNode reverse(ListNode n, int k) {
        ListNode pre = n;
        int m = k;
        ListNode pren = n;
        while (m > 0 && pren != null) {
            pren = pren.next;
            m--;
        }
        
        if (m > 0) {
            return n;
        }
        
        ListNode newHead = null;
        while (n != null && k > 0) {
            ListNode tmp = n.next;
            n.next = newHead;
            newHead = n;
            n = tmp;
            k--;
        }
    
        pre.next = pren;
        return newHead;
    }
}
