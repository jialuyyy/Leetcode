/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class UniqueBinarySearchTreeII {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ret = new ArrayList<TreeNode>();
        if (n <= 0) {
            return ret;
        }
        
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> ret = new ArrayList<TreeNode>();
        if (start > end) {
            ret.add(null);
            return ret;
        }
        
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);
            
            for (TreeNode leftNode: left) {
                for (TreeNode rightNode: right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    ret.add(root);
                }
            }
        }
        return ret;
        
    }
}
