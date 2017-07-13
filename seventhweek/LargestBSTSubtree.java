//1. whether BST
//2.If it is, count the total nodes of the subtree
//Time Complexity: O(n ^ 2), need to do optimization
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LargestBSTSubtree {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (isValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE)) {
            return count(root);
        }
        
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    
    private boolean isValid(TreeNode root, Integer max, Integer min) {
        if (root == null) {
            return true;
        }
        
        if (root.val >= max || root.val <= min) {
            return false;
        }
        
        return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
    }
    
    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return count(root.left) + count(root.right) + 1;
    }
}

//use a wrapper class to do bottom up
//size is the current count for current node, max is the max value of the current subtree and min is the minimum value of the current
//subtree
//when the node == null, the maxValue should be the Integer.MIN_VALUE and the minValue should be the Integer.MAX_VALUE,
//which will ensure that the root.val is in the range. if the left or the right subtree is not a BST, return ResultType(-1, 0, 0)
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
    class ResultType {
        int size;
        int max;
        int min;
        
        public ResultType(int size, int max, int min) {
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int[] max = new int[1];
        helper(root, max);
        
        return max[0];
    }
    
    private ResultType helper(TreeNode root, int[] max) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        ResultType left = helper(root.left, max);
        ResultType right = helper(root.right, max);
        
        
        if (left.size == -1 || right.size == -1 || left.max >= root.val || right.min <= root.val) {
            return new ResultType(-1, 0, 0);
        } else {
            max[0] = Math.max(left.size + right.size + 1, max[0]);
            return new ResultType(left.size + right.size + 1, Math.max(root.val, right.max), Math.min(root.val, left.min));
        }
    }
    
    
}
