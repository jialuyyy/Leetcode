/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LongestUnivaluePath {
    class ResultType {
        int crossMax;
        int nonCrossMax;
        public ResultType(int crossMax, int nonCrossMax) {
            this.crossMax = crossMax;
            this.nonCrossMax = nonCrossMax;
        }
    }
    private int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return max;
    }
    
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        int path = 0;
        int leftPath = 0;
        int rightPath = 0;
        if (root.left != null && root.val == root.left.val) {
            path += left.nonCrossMax + 1;
            leftPath += left.nonCrossMax + 1;
        }
        
        if (root.right != null && root.val == root.right.val) {
            path += right.nonCrossMax + 1;
            rightPath += right.nonCrossMax + 1;
        }
        
        max = Math.max(max, path);
        
        return new ResultType(path, Math.max(leftPath, rightPath));
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LongestUnivaluePath {
    private int ans = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        helper(root);
        return ans;
    }
    
    public int helper(TreeNode node) {
        if (node == null)
            return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        
        int leftPath = 0;
        int rightPath = 0;
        
        if (node.left != null && node.left.val == node.val) {
            leftPath += left + 1;
        }
        
        if (node.right != null && node.right.val == node.val) {
            rightPath += right + 1;
        }
        
        ans = Math.max(ans, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}
