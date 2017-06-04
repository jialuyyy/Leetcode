/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8*/

//beats 74.55%
//iterate over two linkedlist and create a dummy node to be the head of the ret list
//when reaching the end of one of the linked lists, get out of the while loop and loop over the one that is not reaching the end.
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
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode ret = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        int sum = 0;
        int mod = 0;
        while (p1 != null && p2 != null) {
            sum = p1.val + p2.val + carry;
            mod = sum % 10;
            carry = sum / 10;
            
            ListNode node = new ListNode(mod);
            ret.next = node;
            ret = ret.next;
            
            p1 = p1.next;
            p2 = p2.next;
        }
        
        while (p1 != null) {
            sum = p1.val + carry;
            mod = sum % 10;
            carry = sum / 10;
            
            ListNode node = new ListNode(mod);
            ret.next = node;
            ret = ret.next;
            
            p1 = p1.next;
        }
        
        while (p2 != null) {
            sum = p2.val + carry;
            mod = sum % 10;
            carry = sum / 10;
            
            ListNode node = new ListNode(mod);
            ret.next = node;
            ret = ret.next;
            
            p2 = p2.next;
        }
        
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            ret.next = node;
        }
        
        return dummy.next;
        
    }
}

//cleaner method(from leetcode discussion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(-1);
        ListNode ret = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;

        int sum = 0;
        while (p1 != null || p2 != null) {
            
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            
            ListNode node = new ListNode(sum % 10);
            ret.next = node;
            ret = ret.next;
            
            sum /= 10;
        }
        
       
        if (sum == 1) {
            ListNode node = new ListNode(sum);
            ret.next = node;
        }
        
        return dummy.next;
        
    }
}
