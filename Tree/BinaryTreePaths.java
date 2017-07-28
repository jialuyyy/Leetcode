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


//get all the left tree paths and the right tree paths, and for every path, add the root value into it, and if 

// the size of the paths is 0, which means it is the leaf node and add the root value into it divide conqure
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
        List<String> paths = new ArrayList<String>();
        if (root == null) {
            return paths;
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        
        for (String l: left) {
            paths.add(root.val + "->" + l);
        }
        
        for (String r: right) {
            paths.add(root.val + "->" + r);
        }
        
        if (paths.size() == 0) {
            paths.add("" + root.val);
        }
        return paths;
    }
    
    
}
