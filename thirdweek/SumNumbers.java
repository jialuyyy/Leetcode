//beats 63.79%
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumNumbers {
    private int ret = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        helper(root, 0);
        return ret;
    }
    
    private void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            ret += sum * 10 + root.val;
            return;
        }
        
        helper(root.left, sum * 10 + root.val);
        helper(root.right, sum * 10 + root.val);
    }
}
