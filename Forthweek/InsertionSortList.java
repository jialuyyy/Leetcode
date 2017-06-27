//beats 19.43%
//keep three pointers: cur, prev and next
//cur points to the node need to be inserted; prev points to dummy node of the new list and next points to the next node of current node

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sortedListHead = new ListNode(-1);
        
        ListNode cur = head;
        ListNode prev = sortedListHead;
        
        while (cur != null) {
            ListNode next = cur.next;
            prev = sortedListHead;
            while (prev.next != null && prev.next.val < cur.val) {
                prev = prev.next;
            }
            
            cur.next = prev.next;
            prev.next = cur;
            cur = next;
        }
        
        return sortedListHead.next;
    }
}
