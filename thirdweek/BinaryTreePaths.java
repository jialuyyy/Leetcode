//beats 73.12%
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
        if (root == null) {
            return ret;
        }
        
        helper(root, "", ret);
        return ret;
    }
    
    private void helper(TreeNode root, String str, List<String> ret) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            ret.add(str + root.val);
            return;
        }
        
        helper(root.left, str + root.val + "->", ret);
        helper(root.right, str + root.val + "->", ret);
    }
}

//use String builder need to reset the length of the string every time, beats 73.12%
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<String>();
        if (root == null) {
            return ret;
        }
        
        helper(root, new StringBuilder(), ret);
        return ret;
    }
    
    private void helper(TreeNode root, StringBuilder sb, List<String> ret) {
        if (root == null) {
            return;
        }
        
        int len = sb.length();
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            ret.add(sb.toString());
            sb.setLength(len);
            return;
        }
        sb.append(root.val + "->");
        helper(root.left, sb, ret);
        helper(root.right, sb, ret);
        sb.setLength(len);
    }
}
