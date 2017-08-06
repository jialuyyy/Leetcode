//Union Find
public class CountComponents {
    class UF {
        int[] father = null;
        
        public UF (int m) {
            father = new int[m];
            
            for (int i = 0; i < m; i++) {
                father[i] = i;
            }
        }
        
        private int find(int a) {
            if (father[a] == a) {
                return a;
            }
            
            return father[a] = find(father[a]);
        }
        
        public boolean connect(int x, int y) {
            int father_x = find(x);
            int father_y = find(y);
            
            if (father_x != father_y) {
                father[father_x] = father[father_y];
                return true;
            }
            
            return false;
        }
    }
    public int countComponents(int n, int[][] edges) {
        if (edges == null || edges.length == 0) {
            return n;
        }
        
        int total = n;
        UF uf = new UF(n);
        
        for (int[] edge: edges) {
            int point1 = edge[0];
            int point2 = edge[1];
            
            if (uf.connect(point1, point2)) {
                total--;
            }
            
        }
        
        return total;
    }
}


//Breadth-first traversal
public class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<Integer>());
        }
        int count = 0;
        //build graph
        for (int[] edge: edges) {
            int point1 = edge[0];
            int point2 = edge[1];
            
            map.get(point1).add(point2);
            map.get(point2).add(point1);
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(visited, map, i);
                count++;
            }
        }
        
        return count;
    }
    
    private void bfs (boolean[] visited, Map<Integer, Set<Integer>> map, int vertex) {
        Deque<Integer> q = new ArrayDeque<Integer>();
        q.offer(vertex);
        visited[vertex] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for (int neighbor: map.get(cur)) {
                if (!visited[neighbor]) {
                    q.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}
