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

//beats 6.76%
//iterative solution
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
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode prev = root;
        stack.push(p);
        
        while (!stack.isEmpty()) {
            prev = p;
            p = stack.peek();
            
            if (p.left != null && p.left != prev && p.right != prev) {
                stack.push(p.left);
            } else {
                if (p.right != null && p.right != prev) {
                    stack.push(p.right);
                } else {
                    ret.add(stack.pop().val);
                }
            }
        }
        
        return ret;
        
    }
    

}
