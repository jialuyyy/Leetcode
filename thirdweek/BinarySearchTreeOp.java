//Insert Node recursion solution
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            return node;
        }
        
        
        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        } else if (root.val < node.val) {
            root.right = insertNode(root.right, node);
        } 
        
        return root;
    }
}

//Insert a node, non-recursive solution
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            return node;
        }
        
        TreeNode prev = null;
        TreeNode cur = root;
        
        while (cur != null) {
            if (cur.val < node.val) {
                prev = cur;
                cur = cur.right;
            } else if (cur.val > node.val) {
                prev = cur;
                cur = cur.left;
            }
        }
        
        if (node.val > prev.val) {
            prev.right = node;
        } else {
            prev.left = node;
        }
        
        return root;
    }
}
