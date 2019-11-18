/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class DiameterOfBinaryTree {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        int diameter = helper(root);
        return ans - 1;
    }
    
    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        ans = Math.max(left + right + 1, ans);
        return Math.max(left, right) + 1;
    }
}
