//top-down recursive solution
//beats 37.50%
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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        Integer maxValue = null;
        Integer minValue = null;
        
        return helper(root, maxValue, minValue);
    }
    
    private boolean helper(TreeNode root, Integer maxValue, Integer minValue) {
        if (root == null) {
            return true;
        }
        
        if ((maxValue != null && root.val >= maxValue) || (minValue != null && root.val <= minValue)) {
            return false;
        }
        
        return helper(root.left, root.val, minValue) && helper(root.right, maxValue, root.val);
    }
}
