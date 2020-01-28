/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ConvertBST {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;
        
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        
        return root;
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
class ConvertBST {
    
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode cur = root;
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            
            cur = stack.pop();
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        
        return root;
    }
}
