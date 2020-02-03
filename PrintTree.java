/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class PrintTree {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ret = new ArrayList<>();
        int height = root == null ? 1 : getHeight(root);
        
        //row number equals to height
        int rows = height;
        //column number is always be the odd
        int columns = (int)(Math.pow(2, height) - 1);
        
        //initialization the row, put column number of empty string into each row
        List<String> row = new ArrayList<>();
        for (int i = 0; i < columns; i++)
            row.add("");
        
        //add rows number of array list into the result list
        for (int i = 0; i < rows; i++) {
            ret.add(new ArrayList<>(row));
        }
        //dfs
        populateRes(root, ret, 0, rows, 0, columns - 1);
        
        return ret;
    }
    
    private void populateRes(TreeNode root, List<List<String>> res, int row, int totalRows, int i, int j) {
        if (row == totalRows || root == null)
            return;
        
        res.get(row).set((i + j) / 2, String.valueOf(root.val));
        
        //left
        populateRes(root.left, res, row + 1, totalRows, i, (i + j) / 2 - 1);
         //right
        populateRes(root.right, res, row + 1, totalRows, (i + j) / 2 + 1, j);
        
    }
    
    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
