//beats 57.16%
//recursive solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        
        root.left.left = root.right;
        root.left.right = root;
        
        root.left = null;
        root.right = null;
        
        return newRoot;
    }
}


//O(1) space non-recursive solution
//beat 57%
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        TreeNode cur = root;
        TreeNode par = null;
        TreeNode sib = null;
        TreeNode next = null;
        while (cur != null) {
            next = cur.left;
            cur.left = sib;
            sib = cur.right;
            cur.right = par;
            par = cur;
            cur = next;
        }
        
        return par;
    }
}
