/*Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.*/

//beats 51.72%
//thoughts: A vaild tree should satisfy two conditions: 1. number of edges + 1 = number of vertex  2. no cycle

//1. hashMap: used to keep <vertex, list of neighbors> pair for every vertex in the graph
//2. hashset: the vertex that connecting with the other vertex will be stored in the hashset
//3. queue: breadth first traverse the graph

//Time Complexity: O(n)
//Space Complexity: used hashMap, hashSet and queue --> O(n)

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length + 1 != n) {
            return false;
        }
        
        Map<Integer, ArrayList<Integer>> neighbors = new HashMap<Integer, ArrayList<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i < n; i++) {
            neighbors.put(i, new ArrayList<Integer>());
        }
        for (int[] edge: edges) {
            int vertex1 = edge[0];
            int vertex2 = edge[1];
        
            neighbors.get(vertex1).add(vertex2);
            neighbors.get(vertex2).add(vertex1);
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(0);
        set.add(0);
        while (!q.isEmpty()) {
            int val = q.poll();
            
            for (int neighbor: neighbors.get(val)) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    q.offer(neighbor);
                }
            }
        }
        
        return set.size() == n;
    }
}


//Union Find
//beats 70.90%
//Time Complexity: O(n)
//Space Complexity: O(1)

public class Solution {
    class UnionFind {
       int[] root;
        
       public UnionFind(int n) {
           this.root = new int[n];
           for (int i = 0; i < n; i++) {
               root[i] = i;
           }
       }
       
       
       private int find (int i) {
           if (root[i] == i) {
               return i;
           }
           
           return root[i] = find(root[i]);
       }
       
       private boolean union(int i, int j) {
           int root1 = find(i);
           int root2 = find(j);
           
           if (root1 != root2) {
               root[root1] = root2;
               return true;
           }
           
           return false;
       }
    }
    public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length + 1 != n) {
            return false;
        }
        
        UnionFind uf = new UnionFind(n);
        
        for (int[] edge: edges) {
            int vertex1 = edge[0];
            int vertex2 = edge[1];
            
            if (!uf.union(vertex1, vertex2)) {
                return false;
            }
        }
        
        return true;
    }
}

