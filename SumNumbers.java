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
    1
   / \ 
  2   3
 */
class SumNumbers {
    private int count = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return count;
    }
    
    private void helper(TreeNode root, int sum) {
        if (root == null)
            return;
        
        if (root.left == null && root.right == null) {
            count += sum * 10 + root.val;
            return;
        }
        
        
        helper(root.left, sum * 10 + root.val);
        helper(root.right, sum * 10 + root.val);
    }
}
