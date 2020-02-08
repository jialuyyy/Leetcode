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
    private int min1 = 0;
    private long ans = Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        min1 = root.val;
        dfs(root);
        return ans == Long.MAX_VALUE ? -1 : (int)ans;
    }
    
    
    private void dfs(TreeNode root) {
        if (root != null) {
            if (min1 < root.val && root.val < ans) {
                ans = root.val;
            } else if (root.val == min1) {
                dfs(root.left);
                dfs(root.right);
            }
        }
    }
}
