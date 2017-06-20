//beats 55.66%
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BuildTreeInorderPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || postorder.length != inorder.length) {
            return null;
        }
        
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int pos = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd]) {
                pos = i;
            }
        }
        
        int leftLen = pos - inStart;
        int rightLen = inEnd - pos;
        
        root.left = helper(inorder, postorder, inStart, pos - 1, postStart, postStart + leftLen - 1);
        root.right = helper(inorder, postorder, pos + 1, inEnd, postStart + leftLen, postEnd - 1);
        
        return root;
    }
}
