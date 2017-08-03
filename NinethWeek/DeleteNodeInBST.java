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
        if (root == null) {
            return null;
        }
        
        TreeNode prev = null;
        TreeNode cur = root;
        
        while (cur != null && cur.val != key) {
            prev = cur;
            if (cur.val > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        
        if (prev == null) {
            return deleteNode(cur);
        } else if (prev.left == cur) {
            prev.left = deleteNode(cur);
        } else {
            prev.right = deleteNode(cur);
        }
        
        return root;
    }
    
    private TreeNode deleteNode(TreeNode cur) {
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
        
        //find the minimum value in the right subtree of current node
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
