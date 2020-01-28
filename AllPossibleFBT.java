/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class AllPossibleFBT {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ret = new ArrayList<>();
        if (N % 2 == 0)
            return ret;
        
        if (N == 1) {
            TreeNode node = new TreeNode(0);
            ret.add(node);
            return ret;
        }
        N = N - 1;
        
        for (int i = 1; i <= N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ret.add(root);
                }
            }
        }
        
        return ret;
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
class Solution {
    Map<Integer, List<TreeNode>> cache = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ret = new ArrayList<>();
        if (N % 2 == 0)
            return ret;
        
        if (cache.containsKey(N)) {
            return cache.get(N);
        }
        if (N == 1) {
            TreeNode node = new TreeNode(0);
            ret.add(node);
            return ret;
        }
        N = N - 1;
        
        for (int i = 1; i <= N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ret.add(root);
                }
            }
        }
        cache.put(N, ret);
        return ret;
    }
}
