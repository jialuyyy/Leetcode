/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Collect {
    private List<TreeNode> ans;
    private Map<String, Integer> count;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        ans = new ArrayList<>();
        collect(root);
        return ans;
    }
    
    public String collect(TreeNode node) {
        if (node == null)
            return "#";
        
        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
        
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2)
            ans.add(node);
        
        return serial;
    }
}
