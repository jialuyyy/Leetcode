/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ClosestKValues {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> ret = new LinkedList<>();
        inorder(root, target, k, ret);
        return ret;
    }
    
    private void inorder(TreeNode root, double target, int k, LinkedList<Integer> res) {
        if (root == null)
            return;
        
        inorder(root.left, target, k, res);
        if (res.size() == k) {
            if (Math.abs(target - root.val) < Math.abs(target - res.peekFirst())) {
                res.removeFirst();
            }
            else
                return;
        }
        
        res.add(root.val);
        inorder(root.right, target, k, res);
    }
}
