// f + a + b + a = 2 (f + a)
// f = b

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        
        ListNode fast = head;
        ListNode slow = head;
        
        ListNode intersect = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if (slow == fast) {
                intersect = slow;
                break;
            }
        }
        
        if (intersect == null)
            return null;
        
        slow = head;
        
        while (slow != intersect) {
            slow = slow.next;
            intersect = intersect.next;
        }
        
        return slow;
        
    }
}
