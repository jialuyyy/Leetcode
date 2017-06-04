/*Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1 */

//use recursion
//beats 29.31%
//Time Complexity: O(n), as every node will be visited once.
//Space Complexity: O(n), if the tree is completely unbalanced.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) 
            return root;
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
    }
}

//breadth-first traversal(from discussion).
//use a queue. at first, only root is in the queue, inverse its left child and right child and put them into the queue. Each time polling
//a node, inverse its left and right child until the queue is empty.
//Time complexity: O(n)
//Space complexity: O(n)
 /* Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            
            if (node.left != null) {
                q.offer(node.left);
            }
            
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        
        return root;
    }
}
