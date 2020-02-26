/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LargestBSTSubtree {
    class ResultType {
        int size;
        int lower;
        int upper;
        
        public ResultType(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
    private int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root);
        return max;
    }
    
    private ResultType traverse(TreeNode root) {
        if (root == null)
            return new ResultType(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        ResultType left = traverse(root.left);
        ResultType right = traverse(root.right);
        
        if (left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower)
            return new ResultType(-1, 0, 0);
        
        int size = left.size + 1 + right.size;
        max = Math.max(max, size);
        return new ResultType(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }
}
