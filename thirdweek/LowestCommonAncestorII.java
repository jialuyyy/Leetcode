//Time Complexity: O(logn)
//worst Case: O(n)
/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class LowestCommonAncestorII {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here   
        
        if (root == null || A == null || B == null) 
            return null;
        
        int heightA = getHeight(A);
        int heightB = getHeight(B);
        
        if (heightA > heightB) {
            return moveUp(A, B, heightA - heightB);
        } else {
            return moveUp(B, A, heightB - heightA);
        }
    }
    
    private int getHeight(ParentTreeNode n) {
        int height = 0;
        while (n != null) {
            n = n.parent;
            height++;
        }
        
        return height;
    }
    
    private ParentTreeNode moveUp(ParentTreeNode A, ParentTreeNode B, int diff) {
        while (diff != 0) {
            A = A.parent;
            diff--;
        }
        
        while (A != B) {
            A = A.parent;
            B = B.parent;
        }
        
        return A;
    }
}
