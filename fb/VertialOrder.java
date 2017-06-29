//beats 54.97%
//level order traversal
//maintain two queues: one is the col index queue and the other is the treenode queue
//the left node's col index is the parent's index minus 1 while the right node's col index is the parent's index plus 1
//need to maintain a max value and a min value to keep the range of the col index so that the tree node will be output in ascending order
//use a hashmap to maintain a key-value pair, key is the col index while value is the list of treenode of current column index
//Time Complexity: O(n)
//Space Complexity: O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class VertialOrder {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        
        Queue<TreeNode> treeNode = new ArrayDeque<TreeNode>();
        Queue<Integer> cols = new ArrayDeque<Integer>();
        
        Map<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
        treeNode.offer(root);
        cols.offer(0);
        int min = 0;
        int max = 0;
        while (!treeNode.isEmpty()) {
            TreeNode cur = treeNode.poll();
            int col = cols.poll();
            
            if (!hashMap.containsKey(col)) {
                List<Integer> list = new ArrayList<Integer>();
                hashMap.put(col, list);
            } 
                hashMap.get(col).add(cur.val);
            
            if (cur.left != null) {
                cols.offer(col - 1);
                treeNode.offer(cur.left);
                min = Math.min(min, col - 1);
            }
            
            if (cur.right != null) {
                cols.offer(col + 1);
                treeNode.offer(cur.right);
                max = Math.max(max, col + 1);
            }
            
        }
        
        for (int i = min; i <= max; i++) {
            List<Integer> l = hashMap.get(i);
            ret.add(l);
        }
        
        return ret;
        
    }
}
