//Divide and Conquer
/*
    1
   2 3
  4 5
  
  the maximum depth for this tree would be 3. for every subtree the maximum depth would be
  Math.max(left, right) + 1
*/
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.max(left, right) + 1;
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
class MaxDepth {
    private int height = 0;
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        
        helper(1, root);
        return height;
    }
    
    private void helper(int cur, TreeNode root) {
        if (root == null)
            return;
        
        if (height < cur) {
            height = cur;
        }
        helper(cur + 1, root.left);
        helper(cur + 1, root.right);
    }
}
