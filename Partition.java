/*Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.*/

//beats 7.78%
//create two linkedlist, one is storing elements less than x and the other one is storing elements larger than or equal to x.
//connecting the two linkedlists and don't forget to set the next of the last element of large linkedlist to be null.
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
public class Partition {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        
        ListNode dummySmall = new ListNode(-1);
        ListNode small = dummySmall;
        ListNode dummyLarge = new ListNode(-1);
        ListNode large = dummyLarge;
        
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        
        small.next = dummyLarge.next;
        large.next = null;
        
        return dummySmall.next;
        
    }
}
