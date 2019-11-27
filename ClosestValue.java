/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ClosestValue {
    private double max = Double.MAX_VALUE;
    private int ret = 0;
    public int closestValue(TreeNode root, double target) {
        if (root == null)
            return ret;
        
        helper(root, target);
        return ret;
    }
    
    private void helper(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        
        double diff = Math.abs(root.val - target);
        if (diff < max) {
            this.max = diff;
            this.ret = root.val;
        }
        
        helper(root.left, target);
        helper(root.right, target);
    }
}
