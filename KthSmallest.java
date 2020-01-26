/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class KthSmallest {
    private int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        
        return ans;
    }
    
    private void helper(TreeNode root, int k) {
        if (root == null)
            return;
        
        helper(root.left, k);
        if (--k == 0) {
            ans = root.val;
        }
        helper(root.right, k);
    }
}
