/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<String>();
        
        helper(ret, new StringBuilder(), root);
        return ret;
    }
    
    private void helper(List<String> ret, StringBuilder sb, TreeNode root) {
        if (root == null) {
            return;
        }
        
        int length = sb.length();
        if (root.left == null && root.right == null) {
            
            sb.append(root.val + "");
            ret.add(sb.toString());
            sb.setLength(length);
            return;
        }
        
        sb.append(root.val + "->");
        helper(ret, sb, root.left);
        helper(ret, sb, root.right);
        
        sb.setLength(length);
    }
}
