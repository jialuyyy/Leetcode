//1. whether BST
//2.If it is, count the total nodes of the subtree
//Time Complexity: O(n ^ 2), need to do optimization
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
        
        if (isValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE)) {
            return count(root);
        }
        
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    
    private boolean isValid(TreeNode root, Integer max, Integer min) {
        if (root == null) {
            return true;
        }
        
        if (root.val >= max || root.val <= min) {
            return false;
        }
        
        return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
    }
    
    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return count(root.left) + count(root.right) + 1;
    }
}
