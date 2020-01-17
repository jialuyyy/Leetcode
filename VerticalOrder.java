/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class VerticalOrder {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        
        //a queue to keep treenode
        Deque<TreeNode> queue = new ArrayDeque<>();
        
        //a queue to keep col number
        Deque<Integer> cols = new ArrayDeque<>();
        
        //Map to keep col index with the treenodes on the tree
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        queue.offer(root);
        cols.offer(0);
        
        int max = 0;
        int min = 0;
        
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int col = cols.poll();
            
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            
            map.get(col).add(cur.val);
            
            if (cur.left != null) {
                queue.offer(cur.left);
                cols.add(col - 1);
                min = Math.min(min, col - 1);
            }
            
            if (cur.right != null) {
                queue.offer(cur.right);
                cols.add(col + 1);
                max = Math.max(max, col + 1);
            }
        }
        
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        
        return res;
    }
}
