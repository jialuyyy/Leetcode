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
 2 3
4 5

preorder:
1 2 4 5 3
1-3
inorder:
4 2 5 1 3
[4 2 5]
[3]
*/
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || inorder.length != preorder.length) {
            return null;
        }
        
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        
        //locate the preorder[preStart] in the inorder array
        int pos = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (preorder[preStart] == inorder[i])
                pos = i;
        }
        
        int leftLength = pos - inStart;
        
        root.left = helper(preorder, inorder, preStart + 1, preStart + leftLength, inStart, pos - 1);
        root.right = helper(preorder, inorder, preStart + leftLength + 1, preEnd, pos + 1, inEnd);
        
        return root;
        
    }
}
