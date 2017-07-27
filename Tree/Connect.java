/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
//use a queue to do the breadth first traversal, push the root into the queue first, every time keep the size
//of the queue, if the current i == size - 1, which means its next should be null

//and for other nodes, it's next should be the next node in queue and every time push the right node and left node of current
//node into the queue.

//extra space used, so need to do optimization to remove the extra space
public class Connect {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        Deque<TreeLinkNode> queue = new ArrayDeque<TreeLinkNode>();
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeLinkNode cur = queue.poll();
                if (i == size - 1) {
                    cur.next = null;
                } else {
                    cur.next = queue.peek();
                }
                
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        
    }
}


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
/*

use two variables, one to keep the level and the other one to iterate over the current level

cur.left.next = cur.right;
cur.right.next = cur.next.left;

cur = cur.next;

level = level.left;
         1
       /  \
      2    3
     / \  / \
    4  5  6  7

*/
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode level = root;
        TreeLinkNode cur = null;
        
        while (level != null) {
            cur = level;
            
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
            
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
            
                cur = cur.next;
            }
            
            level = level.left;
        }
    }
}
