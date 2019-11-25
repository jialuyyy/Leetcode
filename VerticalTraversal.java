/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// find the location and report the location
//preorder traversal to find the locations, left child is (x - 1, y + 1) and right child is (x + 1, y + 1)
// sort the location firstly by x coordinate, then by y coordinate and then by the value of the treenode
class Solution {
    
    class Location implements Comparable<Location> {
        int x;
        int y;
        int val;
        
        public Location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        @Override 
        public int compareTo(Location that) {
            if (this.x != that.x) {
                return this.x - that.x;   
            } else if (this.y != that.y) {
                return this.y - that.y;
            } else {
                return this.val - that.val;
            }
            
        }
    }
    
    
          /* 3(0,0)
9.(-1, -1)    20 (1,1)
             15.(0,2)    7 (2, 2)*/
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ret;
        
        List<Location> locations = new ArrayList<>();
        dfs(root, 0, 0, locations);
        
        Collections.sort(locations);
        
        ans.add(new ArrayList<Integer>());

        int prev = locations.get(0).x;

        for (Location loc: locations) {
            if (loc.x != prev) {
                prev = loc.x;
                ans.add(new ArrayList<Integer>());
            }

            ans.get(ans.size() - 1).add(loc.val);
        }

        return ans;

        
    }
    
    private void dfs(TreeNode cur, int x, int y, List<Location> locations) {
        if (cur == null) {
            return;
        }
        
        locations.add(new Location(x, y, cur.val));
        dfs(cur.left, x - 1, y + 1, locations);
        dfs(cur.right, x + 1, y + 1, locations);
    }
}
