/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LcaDeepestLeaves {
    class ResultType {
        TreeNode node;
        int depth;
        
        public ResultType(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return helper(root, 0).node;
    }
    
    private ResultType helper(TreeNode node, int depth) {
        if (node == null) {
            return new ResultType(null, depth);
        }
        
        ResultType l = helper(node.left, depth + 1);
        ResultType r = helper(node.right, depth + 1);
        
        if (l.depth == r.depth) {
            return new ResultType(node, l.depth);
        }
        
        return l.depth > r.depth ? l : r;
    }
}
