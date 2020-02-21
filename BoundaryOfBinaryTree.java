/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BoundaryOfBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null)
            return ret;
        
        ret.add(root.val);
        leftBoundary(root.left, ret);
        leaves(root.left, ret);
        leaves(root.right, ret);
        rightBoundary(root.right, ret);
        
        return ret;
    }
    
    private void leftBoundary(TreeNode root, List<Integer> ret) {
        if (root == null || (root.left == null && root.right == null))
            return;
        
        ret.add(root.val);
        if (root.left != null)
            leftBoundary(root.left, ret);
        else
            leftBoundary(root.right, ret);
    }
    
    private void rightBoundary(TreeNode root, List<Integer> ret) {
        if (root == null || (root.left == null && root.right == null))
            return;
        
        if (root.right != null)
            rightBoundary(root.right, ret);
        else
            rightBoundary(root.left, ret);
        ret.add(root.val);
    }
    
    private void leaves(TreeNode root, List<Integer> ret) {
        if (root == null)
            return;
        
        if (root.left == null && root.right == null) {
            ret.add(root.val);
            return;
        }
        
        leaves(root.left, ret);
        leaves(root.right, ret);
    }
}
