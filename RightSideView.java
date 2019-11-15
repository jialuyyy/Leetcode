/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null)
            return ret;
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == size - 1)
                    ret.add(cur.val);
                if (cur.left != null)
                    queue.offer(cur.left);
                
                if (cur.right != null)
                    queue.offer(cur.right);
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        
        helper(ret, root, 0);
        return ret;

    }
    
    private void helper(List<Integer> ret, TreeNode curr, int height) {
        if (curr == null)
            return;
        
        if (height == ret.size()) {
            ret.add(curr.val);
        }
        
        helper(ret, curr.right, height + 1);
        helper(ret, curr.left, height + 1);
    }
}
