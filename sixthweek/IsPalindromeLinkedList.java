/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//beats 36%
public class IsPalindromeLinkedList {
    //1-2-3-4
    //find middle, reverse the second half and then compare
    //1-2
    //4-3
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        //find middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode secondHalf = slow.next;
        slow.next = null;
        
        ListNode newNode = reverse(secondHalf);
        
        slow = head;
        
        while (slow != null && newNode != null) {
            if (slow.val != newNode.val) {
                return false;
            }
            slow = slow.next;
            newNode = newNode.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        
        return newHead;
    }
}
