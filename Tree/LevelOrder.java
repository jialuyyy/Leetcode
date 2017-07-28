/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
   1
  2 3
*/
public class LevelOrder {
    public List<List<Integer>>  levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        
        Deque<TreeNode> q = new ArrayDeque<TreeNode>();
        
        q.offer(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                list.add(cur.val);
                
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            
            ret.add(new ArrayList<Integer>(list));
        }
        
        return ret;
    }
}
