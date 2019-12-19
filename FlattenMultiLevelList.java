/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

1---2---3---4---5---6--NULL
        |
        7---8---9---10--NULL
            |
            11--12--NULL
            
  1---2---NULL
  |
  3---NULL
            
*/
class FlattenMultiLevelList {
  public Node flatten(Node head) {
    if (head == null) return head;
    Node pseudoHead = new Node(0, null, head, null);

    flattenDFS(pseudoHead, head);

    pseudoHead.next.prev = null;
    return pseudoHead.next;
  }
  /* return the tail of the flatten list */
  public Node flattenDFS(Node prev, Node curr) {
    if (curr == null) return prev;
    curr.prev = prev;
    prev.next = curr;

    Node tempNext = curr.next;

    Node tail = flattenDFS(curr, curr.child);
    curr.child = null;

    return flattenDFS(tail, tempNext);
  }
}
