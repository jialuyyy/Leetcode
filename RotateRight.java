/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//Input: 1->2->3->4->5->NULL, k = 2
//Output: 4->5->1->2->3->NULL

class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int listNum = 1;
        ListNode tail = head;
        
        //find tail and count listNum
        while(tail.next != null){
            listNum++;
            tail = tail.next;
        }
        tail.next = head;
        int newHeadIndex = listNum - k % listNum;

        for(int i = 0; i < newHeadIndex; i++){
            tail = tail.next;
        }
        
        head = tail.next;
        tail.next = null;

        return head;
    }
}


class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        
        int len = 0;
        ListNode p = head;
        ListNode tail = head;
        while (p != null) {
            if (p.next == null)
                tail = p;
            p = p.next;
            len++;
        }
        
        k = k % len;
        if (k == 0)
            return head;
        
        int count = len - k;
        
        p = head;
        while (count > 1) {
            p = p.next;
            count--;
        }
        
        tail.next = head;
        head = p.next;
        p.next = null;
        
        return head;
    }
}
