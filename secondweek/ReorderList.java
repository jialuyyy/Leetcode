/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//beats: 21.21%
//1.find the middle of the whole listNode;
//2.reverse the LinkedList from the next listnode of the slow
//3.connecting the listnode of the two linked lists
//Time Complexity: O(n)

public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        } 
        
        //1. find middle
        
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode reverseHead = slow.next;
        slow.next = null;
        
        //reverse the ListNode from the next node of the slow 
        ListNode second = reverse(reverseHead);
        
        //connect the two lists
        while (second != null) {
            ListNode tmp = second.next;
            second.next = head.next;
            head.next = second;
            head = head.next.next;
            second = tmp;
        }
       
    }
    
    private ListNode reverse(ListNode reverseHead) {
        ListNode newHead = null;
        while (reverseHead != null) {
            ListNode tmp = reverseHead.next;
            reverseHead.next = newHead;
            newHead = reverseHead;
            reverseHead = tmp;
        }
        return newHead;
    }
}
