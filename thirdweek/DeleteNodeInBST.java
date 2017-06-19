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
//use a prev pointer and a current pointer to search for the key value treenode in the bst, if prev pointer is null, it means the value need 
//to be deleted is root.
//when doing the delete, if current node == null, means the target key does not exist in the tree, so return null; if current node only has
//left child or right child, return either of it. The most complicated situation is current node has both left child and right child
//firstly, we need to find the smallest value of its right child, which should be the left most child of its right child, connecting the 
//left child of current node to the smallest treenode. if the right child does not have any left child, return the right child; else, connect
//the right child of smallest node to the left of smallest node's parent, and put the current node's right child to the right of the smallest node
//return the smallest node.
  10
5    20
    18  30
   14   25  40
  12
    13
   
 */
 
public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode pre = null;
        
        while (cur != null && cur.val != key) {
            pre = cur;
            if (cur.val < key) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        
        if (pre == null) {
            return deleteCurNode(cur);
        } else if (pre.left == cur) {
            pre.left = deleteCurNode(cur);
        } else {
            pre.right = deleteCurNode(cur);
        }
        
        return root;
    }
    
    private TreeNode deleteCurNode(TreeNode cur) {
        if (cur == null) {
            return null;
        }
        
        if (cur.left == null) {
            return cur.right;
        }
        
        if (cur.right == null) {
            return cur.left;
        }
        
        TreeNode next = cur.right;
        TreeNode prev = null;
        
        while (next.left != null) {
            prev = next;
            next = next.left;
        }
        
        next.left = cur.left;
        
        if (cur.right != next) {
            prev.left = next.right;
            next.right = cur.right;
        }
        
        return next;
    }
}
