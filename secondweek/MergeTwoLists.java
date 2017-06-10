/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//iterate over two lists, when not reaching the end of both of the two lists, connecting the smaller listnode to the new list.
//connecting the remaining list nodes of longer linked list to the new list.

//O(n): n is the length of the longer linked list

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tmp.next = p1;
                p1 = p1.next;
            } else {
                tmp.next = p2;
                p2 = p2.next;
            }
            
            tmp = tmp.next;
        }
        
        if (p1 != null) {
            tmp.next = p1;
        }
        
        if (p2 != null) {
            tmp.next = p2;
        }
        
        return dummy.next;
    }
}
