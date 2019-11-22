/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ret = new ArrayList<>();
        if (n == 0)
            return ret;
        return generateHelper(1, n);
    }
    
    private List<TreeNode> generateHelper(int start, int end) {
        List<TreeNode> ret = new ArrayList<>();
        if (start > end) {
            ret.add(null);
            return ret;
        }
        
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateHelper(start, i - 1);
            List<TreeNode> right = generateHelper(i + 1, end);
            
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = l;
                    cur.right = r;
                    
                    ret.add(cur);
                }
            }
        }
        
        return ret;
    }
}
