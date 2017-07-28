/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //height defines the distance between the current node to the leaf node
 /*
    1
   2 3
  4 5
  
  for 4 5 3 the height will be 0
  for 2 3 the height will be 1
  for 1 the height will be 2
  
  the node at the same height will be in the same sublist of the result list and the height will be the index of the node's sub list in the result
  
  bottom up recursion.
  
  for example, when the current node is 4 so the heihgt will be 0 and the ret.size == 0, so need to create a new arraylist.
  if (ret.size() < level + 1)
 
 */
public class FindLeaves {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return ret;
        }
        
        height(root, ret);
        
        return ret;
    }
    
    private int height(TreeNode root, List<List<Integer>> ret) {
        if (root == null) {
            return -1;
        }
        
        int level = Math.max(height(root.left, ret), height(root.right, ret)) + 1;
        if (ret.size() < level + 1) {
            ret.add(new ArrayList<Integer>());
        }
        
        ret.get(level).add(root.val);
        return level;
    }
}
