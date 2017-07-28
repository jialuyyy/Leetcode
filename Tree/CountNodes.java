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
 4 5 6 7
9

if (rightHeight == h - 1) which means the left tree is complete, so move the root to the root.right and nodes += 1 << h

else which means the right tree is complete and move the root to the left and nodes += 1 << (h - 1)

As it is a complete tree, when calculating the height of the tree, just need to iterate over the left most branch of the binary tree
*/
public class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int height = height(root);
        int nodes = 0;
        while (root != null) {
            int rightHeight = height(root.right);
            
            if (rightHeight == height - 1) {
                nodes += (1 << height);
                root = root.right;
            } else {
                nodes += (1 << (height - 1));
                root = root.left;
            }
            
            height--;
        }
        return nodes;
    }
    
    private int height(TreeNode root) {
        return root == null ? -1 : height(root.left) + 1;
    }
}
