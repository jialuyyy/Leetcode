/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        
        helper(root, sum, new ArrayList<Integer>(), ret);
        return ret;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> list, List<List<Integer>> ret) {
        if (root == null) {
            return;
        }
        
        list.add(root.val);
        if (sum == root.val && root.left == null && root.right == null) {
            ret.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
            return;
        }
        
        helper(root.left, sum - root.val, list, ret);
        helper(root.right, sum - root.val, list, ret);
        list.remove(list.size() - 1);
    }
}
