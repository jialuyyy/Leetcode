/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindSecondMinimumValue {
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> uniques = new HashSet<>();
        dfs(root, uniques);
        
        //the minimum value is the root value for sure
        int min = root.val;
        
        long ans = Long.MAX_VALUE;
        
        for (int v : uniques) {
            if (min < v && v < ans) {
                ans = v;
            }
        }
        
        return ans == Long.MAX_VALUE ? -1 : (int)ans;
    }
    
    
    private void dfs(TreeNode root, Set<Integer> set) {
        if (root != null) {
            set.add(root.val);
            dfs(root.left, set);
            dfs(root.right, set);
        }
    }
}
