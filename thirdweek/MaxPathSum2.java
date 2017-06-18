/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class maxPathSum2 {
    /**
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }
        
        int left = Math.max(maxPathSum2(root.left), 0);
        int right = Math.max(maxPathSum2(root.right), 0);
        
        return Math.max(root.val, Math.max(left,right) + root.val);
    }
}
