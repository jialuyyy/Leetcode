/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode pre = null;
        
        while (cur != null && cur.val != key) {
            pre = cur;
            if (cur.val < key) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        
        if (pre == null) {
            return deleteCurNode(cur);
        } else if (pre.left == cur) {
            pre.left = deleteCurNode(cur);
        } else {
            pre.right = deleteCurNode(cur);
        }
        
        return root;
    }
    
    private TreeNode deleteCurNode(TreeNode cur) {
        if (cur == null) {
            return null;
        }
        
        if (cur.left == null) {
            return cur.right;
        }
        
        if (cur.right == null) {
            return cur.left;
        }
        
        TreeNode next = cur.right;
        TreeNode prev = null;
        
        while (next.left != null) {
            prev = next;
            next = next.left;
        }
        
        next.left = cur.left;
        
        if (cur.right != next) {
            prev.left = next.right;
            next.right = cur.right;
        }
        
        return next;
    }
}
