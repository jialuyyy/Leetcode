/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("#,");
                } else {
                    sb.append(node.val + ",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        
        sb.setLength(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("{}")) {
            return null;
        }
        
        String str = data.substring(1, data.length() - 1);
        String[] arr = str.split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        boolean isLeft = true;
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].equals("#")) {
                
                TreeNode cur = new TreeNode(Integer.parseInt(arr[i]));
                list.add(cur);
                if (isLeft) {
                    list.get(index).left = cur;
                } else {
                    list.get(index).right = cur;
                }
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
