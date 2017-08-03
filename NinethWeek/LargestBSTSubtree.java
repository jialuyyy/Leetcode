/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LargestBSTSubtree {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE)) {
            return count(root);
        }
        
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    
    private boolean isBST(TreeNode root, int max, int min) {
        if (root == null) {
            return true;
        }
        
        if (root.val >= max || root.val <= min) {
            return false;
        }
        
        return isBST(root.left, root.val, min) && isBST(root.right, max, root.val);
    }
    
    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return count(root.right) + count(root.left) + 1;
    }
}
