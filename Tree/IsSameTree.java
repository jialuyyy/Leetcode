/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
  1      1
 2  3   2  3
*/

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if (p == null && q == null) {
            return true;
        }
        
        if (p == null || q == null) {
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val;
    }
}
