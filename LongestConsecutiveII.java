/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LongestConsecutiveII {
    private int maxValue = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return maxValue;
    }
    
    //the first value represents the increase length
    //the second value represents the decrease length
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        
        int inc = 1;
        int dec = 1;
        if (root.left != null) {
            int[] l = dfs(root.left);
            if (root.val == root.left.val + 1)
                dec = l[1] + 1;
            else if (root.val == root.left.val - 1)
                inc = l[0] + 1;
        }
        
        if (root.right != null) {
            int[] r = dfs(root.right);
            if (root.val == root.right.val + 1)
                dec = Math.max(dec, r[1] + 1);
            else if (root.val == root.right.val - 1)
                inc = Math.max(inc, r[0] + 1);
        }
        
        maxValue = Math.max(maxValue, dec + inc - 1);
        
        return new int[]{inc, dec};
    }
}
