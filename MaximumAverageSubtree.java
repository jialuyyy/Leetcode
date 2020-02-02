/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class MaximumAverageSubtree {
    class ResultType {
        int sum;
        int count;
        
        public ResultType(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
    
    private double max = 0.0;
    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return max;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        int sum = left.sum + right.sum + root.val; 
        int count = left.count + right.count + 1;
        
        max = Math.max(max, ((double)sum / count));
        return new ResultType(sum, count);
    }
}
