/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //O(n) space
public class RecoverTree {
    public void recoverTree(TreeNode root) {
        //inorder traversal to find the two nodes first
        
        List<TreeNode> list = new ArrayList<TreeNode>();
        helper(root, list);
        
        List<TreeNode> pair = new ArrayList<TreeNode>();
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1 && list.get(i).val > list.get(i + 1).val) {
                pair.add(list.get(i));
                pair.add(list.get(i + 1));
            }
        }
        
        if (pair.size() == 2) {
            swap(pair.get(0), pair.get(1));
        } else {
            swap(pair.get(0), pair.get(3));
        }
    }
    
    private void swap(TreeNode node1, TreeNode node2) {
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
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
class RecoverTree {
    private TreeNode firstElement = null;
    private TreeNode secondElement = null;
    
    private TreeNode prevElement = null;
    
    public void recoverTree(TreeNode root) {
        traverse(root);
        
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    
    private void traverse(TreeNode root) {
        if (root == null)
            return;
        
        traverse(root.left);
        
        if (prevElement != null && firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }
        
        if (prevElement != null && firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }
        
        prevElement = root;
        traverse(root.right);
    }
}
