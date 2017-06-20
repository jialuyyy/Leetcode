// bfs to find all the node and copy the value, and put the copied node and original node into a hashmap, use a hashset to avoid pushing duplciates
// after building the relationship between the original node and the copied node, copy the neighbors. use the hashset to iterate over the 
// nodes in the graph, for every node, iterate over their neighbors and building the neighboring relationship between the copied nodes.

//Time Complexity: O(n)
//Space Complexity: O(n)
//two pass

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        Queue<UndirectedGraphNode> q = new ArrayDeque<UndirectedGraphNode>();
        
        Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        q.offer(node);
        set.add(node);
        
        while(!q.isEmpty()) {
            
            UndirectedGraphNode cur = q.poll();
            UndirectedGraphNode newNode = new UndirectedGraphNode(cur.label);
            map.put(cur, newNode);
            
            for (UndirectedGraphNode neighbor: cur.neighbors) {
                if (!set.contains(neighbor)) {
                    q.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }
        
        for (UndirectedGraphNode n: set) {
            UndirectedGraphNode copied = map.get(n);
            for (UndirectedGraphNode neighbor: n.neighbors) {
                copied.neighbors.add(map.get(neighbor));
            }
        } 
        
        return map.get(node);
    }
    
    
    //one pass solution
    //Time complexity: O(n)
    //Space Complexity: O(n)
    /**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q = new ArrayDeque<UndirectedGraphNode>();
        q.offer(node);
        map.put(node, new UndirectedGraphNode(node.label));
        
        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (map.get(neighbor) == null) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    q.offer(neighbor);
                }
                
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }
}
}
