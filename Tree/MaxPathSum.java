//divide and conquer to get the highest node that can be the input

/*
  6
 5 -100
3 2



node 3 will return 3, node 2 will return 2
node 5 will return 8, node -100 will return 0;
node 6 will return 8 + 6 = 14


use a maxValue as a global variable to store the maximum value

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaxPathSum {
    private int maxValue = 0;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        helper(root);
        return maxValue;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        
        max = Math.max(left + right + root.val, max);
        
        return Math.max(left, right) + root.val;
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
/* use a wrapper class to record the single path sum and the max path sum of current node
   single path sum means the max sum right from this node straight down and the max sum means the maxsum going through this node
 */

//divide and conqure
//if the root == null, then the single sum should be 0 and the max sum should be Integer.MIN_VALUE
// if the root != null, then the single sum should be the Math.max(left, right) + root.val, and if the value is negative, we should set
//it to 0. for the max sum of current node, it should be the max sum of its left node, max sum of its right node, or left.singleSum + right.singleSum + root.val
//the maximum of these three



public class Solution {
    class ResultType {
        int singlePath = 0;
        int maxPath = 0;
        
        //single path is from current node to go straight down and the maximum value
        //max path is the maximum sum through current node
        public ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
    public int maxPathSum(TreeNode root) {
        
        ResultType rt = helper(root);
        return rt.maxPath;
    }
    
    private ResultType helper(TreeNode root) {
        //if root == null
        //single path sum == 0;
        // max path sum == Integer.MIN_VALUE
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(0, singlePath);
        
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath= Math.max(maxPath, left.singlePath + right.singlePath + root.val);
        
        return new ResultType(singlePath, maxPath);
        
    }
}
