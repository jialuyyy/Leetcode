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
    4 5

{1,2,3,#,# 4,5, #,#,#,#}

level order traversal

if null, mark as "#" and do not need to check its left and right child


*/
public class Codec {

    // Encodes a tree to a single string.
    Deque<TreeNode> queue = null;
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        
        queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                
                if (cur == null) {
                    sb.append("#,");
                } else {
                    sb.append(cur.val + ",");
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
        }
        
        sb.setLength(sb.length() - 1);
        sb.append("}");
        
        return sb.toString();
    }
    
    
/*
    1
   2 3
    4 5

{1,2,3,#,# 4,5, #,#,#,#}
 left right left right
 
 ArrayList
 {1,2,3...}
level order traversal

if null, mark as "#" and do not need to check its left and right child


*/
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String sub = data.substring(1, data.length() - 1);
        
        if (sub.length() == 0) {
            return null;
        }
        
        String[] str = sub.split(",");
        
        //root of the tree
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        boolean isLeft = true;
        int index = 0;
        //{1,2,3,#,# 4,5, #,#,#,#}
        //1
        for (int i = 1; i < str.length; i++) {
            if (!str[i].equals("#")) {
                TreeNode cur = new TreeNode(Integer.parseInt(str[i]));
                if (isLeft) {
                    list.get(index).left = cur;
                } else {
                    list.get(index).right = cur;
                }
            
                list.add(cur);
            }
            
            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
