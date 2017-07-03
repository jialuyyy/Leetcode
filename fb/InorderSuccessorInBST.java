//primitive idea, use a list to keep the inorder traversal treenode of the given bst
//locate the target treenode in the list and return the next one
//Time complexity: O(n)
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
public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        
        List<TreeNode> list = new ArrayList<TreeNode>();
        helper(root, list);
        
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            if (node.val == p.val) {
                if (i == list.size() - 1) {
                    return null;
                } else {
                    return list.get(i + 1);
                }
            }
        }
        
        return null;
    }
    
    private void helper(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        
        helper(root.left, list);
        list.add(root);
        helper(root.right, list);
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
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        
        TreeNode successor = null;
        while (root != null && root.val != p.val) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        //no p
        if (root == null) {
            return null;
        }
        
        //if root.right == null, return successor
        if (root.right == null) {
            return successor;
        }
        
        //root.right != null, return the left most treenode of the right node
        TreeNode cur = root.right;
        while (cur.left != null) {
            cur = cur.left;
        }
        
        return cur;
    }
}
