/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//maintain a minHeap
//Time Complexity: O(nklog(n)) n is the length of the lists array and k is the average length of each list
//Space Complexity: O(n) n is the length of the lists

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        Queue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        
        for (ListNode list: lists) {
            if (list != null) {
                q.offer(list);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        while(!q.isEmpty()) {
            ListNode node = q.poll();
            tmp.next = node;
            tmp = tmp.next;
            
            if (node.next != null)
                q.offer(node.next);
        }
        
        return dummy.next;
        
    }
}
