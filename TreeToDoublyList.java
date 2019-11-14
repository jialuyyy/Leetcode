/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class TreeToDoublyList {
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        
        helper(root);
        last.right = first;
        first.left = last;
        
        return first;
    }
    private Node last;
    private Node first;
    private void helper(Node root) {
        if (root == null)
            return;
        
        helper(root.left);
        
        if (last != null) {
            last.right = root;
            root.left = last;
        } else {
            first = root;
        }
        
        last = root;
        
        
        helper(root.right);
    }
}
