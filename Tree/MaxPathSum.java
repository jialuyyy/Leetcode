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
