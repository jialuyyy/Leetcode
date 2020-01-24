/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// for every node, if the left subtree and right subtree are all balanced and the height of the left subtree and the height of the right 
//subtree is less than or equal to 1, which means it is a balanced search tree

public class isBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }
    
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = depth(root.left);
        int right = depth(root.right);
        
        return Math.max(left, right) + 1;
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
       return maxDepth(root) != -1;
    }
    
    private int maxDepth(TreeNode node) {
        if (node == null)
            return 0;
        
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;
        
        return Math.max(left, right) + 1;
    }
}
