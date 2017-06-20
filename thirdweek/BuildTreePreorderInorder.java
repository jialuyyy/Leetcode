//beats 38.25%
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BuildTreePreorderInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int pos = 0;
        
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                pos = i;
            }
        }
        
        int leftLen = pos - inStart;
        int rightLen = inEnd - pos;
        
        root.left = helper(preorder, inorder, preStart + 1, preStart + leftLen, inStart, pos - 1);
        root.right = helper(preorder, inorder, preStart + leftLen + 1, preEnd, pos + 1, inEnd);
        
        return root;
    }
}
