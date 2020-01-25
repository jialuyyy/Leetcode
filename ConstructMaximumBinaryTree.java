/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int indexMax = start;
        int max = nums[start];
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                indexMax = i;
            }
        } 
        
        TreeNode node = new TreeNode(nums[indexMax]);
        node.left = helper(nums, start, indexMax - 1);
        node.right = helper(nums, indexMax + 1, end);
        
        return node;
    }
}
