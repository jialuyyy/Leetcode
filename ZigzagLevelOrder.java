/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null)
            return ret;
        
        dfs(root, 0, ret);
        return ret;
    }
    
    private void dfs(TreeNode node, int level, List<List<Integer>> ret) {
        if (level >= ret.size()) {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            ret.add(list);
        } else {
            if (level % 2 == 0) {
                ret.get(level).add(node.val);
            } else {
                ret.get(level).add(0, node.val);
            }
        }
        
        if (node.left != null)
            dfs(node.left, level + 1, ret);
        if (node.right != null)
            dfs(node.right, level + 1, ret);
    }
}
