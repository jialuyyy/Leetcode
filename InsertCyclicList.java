/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class InsertCyclicList {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }
        Node p = head;
        while (true) {
            if (p.val <= insertVal && p.next.val >= insertVal) {
                Node newNode = new Node(insertVal);
                newNode.next = p.next;
                p.next = newNode;
                break;
            } else if (p.val > p.next.val) {
                if (p.val <= insertVal || p.next.val >= insertVal) {
                    Node newNode = new Node(insertVal);
                    newNode.next = p.next;
                    p.next = newNode;
                    break;
                }
            } else if (p.next == head) {
                Node newNode = new Node(insertVal);
                newNode.next = p.next;
                p.next = newNode;
                break;
            }
            
            p = p.next;
        }
        
        return head;
    }
}
