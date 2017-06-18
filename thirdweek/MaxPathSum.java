//beats 19.80%
//use a global variable to keep the current max value
//bottom-up solution, the left and right maintains the sum that will pass through the root

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaxPathSum {
    private int ret = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        helper(root);
        
        return ret;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        
        ret = Math.max(left + right + root.val, ret);
        return Math.max(left, right) + root.val;
    }
}
