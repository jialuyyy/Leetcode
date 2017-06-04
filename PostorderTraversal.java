//beats 57.53%
//DFS traversal
//Time Complexity: O(n)
//Space Complexity: O(n)
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }
        
        helper(root, ret);
        return ret;
    }
    
    private void helper(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        
        helper(root.left, ret);
        helper(root.right, ret);
        ret.add(root.val);
    }
}
