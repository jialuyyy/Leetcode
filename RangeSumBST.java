/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class RangeSumBST {
    private int ans = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        dfs(root, L, R);
        return ans;
    }
    
    private void dfs(TreeNode root, int L, int R) {
        if (root == null)
            return;
        
        if (root.val >= L && root.val <= R) {
            ans += root.val;
        }
        
        rangeSumBST(root.left, L, R);
        rangeSumBST(root.right, L, R);
    }
}
