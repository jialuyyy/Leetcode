/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class IsSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }
    private boolean traverse(TreeNode s, TreeNode t) {
        return s != null && (equals(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }
    private boolean equals(TreeNode x, TreeNode y) {
        if (x == null && y == null)
            return true;
        
        if (x == null || y == null)
            return false;
        
        return x.val == y.val && equals(x.left, y.left) && equals(x.right, y.right);
    }
  
}
