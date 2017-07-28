/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        
        return helper(root, 0, sum);
    }
    
    private boolean helper(TreeNode root, int cur, int target) {
        
        if (root == null) {
            return false;
        }
        if (cur + root.val == target && root.left == null && root.right == null) {
            return true;
        }
    
        
        boolean left = helper(root.left, cur + root.val, target);
        boolean right = helper(root.right, cur + root.val, target);
        
        return left || right;
    }
}


//more concise solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
