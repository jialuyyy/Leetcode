/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
  10
 5  15
2 7 11 20

2 5 7 10 11 15 20

inorder traversal use stack to implement


*/

public class BSTIterator {
    
    Deque<TreeNode> stack = null;
    TreeNode cur = null;
    
    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<TreeNode>();
        cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || cur != null; 
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode ret = null;
        if (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            
            ret = stack.pop();
            if (ret.right != null) {
                cur = ret.right;
            }
        }
        
        return ret.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
