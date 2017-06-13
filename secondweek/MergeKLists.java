/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//maintain a minHeap
//Time Complexity: O(klog(n)) n is the length of the lists array and k is the number of nodes
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


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//use merge sort, beats 82.01%
//Space Complexity: O(log(n)) n is the length of the lists
//Time Complexity: O(klog(n)) k is the number of nodes in the list and n is the length of the lists.
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        
        return mergeSort(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeSort(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        
        int mid = start + (end - start) / 2;
        
        ListNode left = mergeSort(lists, start, mid);
        ListNode right = mergeSort(lists, mid + 1, end);
        
        return merge(left, right);
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        
        while (left != null && right != null) {
            if (left.val < right.val) {
                tmp.next = left;
                left = left.next;
            } else {
                tmp.next = right;
                right = right.next;
            }
            tmp = tmp.next;
        }
        
        if (left != null) {
            tmp.next = left;
        }
        
        if (right != null) {
            tmp.next = right;
        }
        
        return dummy.next;
    }
}
