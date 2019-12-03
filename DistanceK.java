/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//three directions: left, right and par
//use dfs and hashmap to store all the parents first and then use bfs to do distance search
class DistanceK {
    private Map<TreeNode, TreeNode> par = null;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ret = new ArrayList<>();
        par = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        
        set.add(target);
        queue.offer(target);
        dfs(root, null);
        
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (dist == K)
                break;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null && !set.contains(cur.left)) {
                    queue.offer(cur.left);
                    set.add(cur.left);
                }
                
                if (cur.right != null && !set.contains(cur.right)) {
                    queue.offer(cur.right);
                    set.add(cur.right);
                }
                
                if (par.get(cur) != null && !set.contains(par.get(cur))) {
                    queue.offer(par.get(cur));
                    set.add(par.get(cur));
                }
            }
            dist++;
        }
        
        
        while(!queue.isEmpty() && dist == K) {
            ret.add(queue.poll().val);
        }
        
        return ret;
    }
    
    private void dfs(TreeNode root, TreeNode parent){
        if (root != null) {
            par.put(root, parent);
            dfs(root.left, root);
            dfs(root.right, root);
        }
    }
}
