//tle
//remove each edge and use bfs to visit every vertices, if all of the vertices are visited, the edge is not critical; otherwise
//the edge is critical; time Complexity : O(E *(V + E))
class CriticalConnections {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ret = new ArrayList<>();
        
        for (int i = 0; i < connections.size(); i++) {
        
            List<List<Integer>> copy = connections.stream()
  .collect(Collectors.toList());
            copy.remove(copy.get(i));
            
            if (isCritical(copy, n)) {
                ret.add(connections.get(i));
            }
        }
        
        return ret;
    }
    
    
    private boolean isCritical(List<List<Integer>> cur, int n) {
        //1,2
        //2,0
        //1,3
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        //1 -> (2,3)
        //2 -> (1,0)
        //0 -> (2)
        //3->(1)
        for (List<Integer> l : cur)  {
            
            int i1 = l.get(0);
            int i2 = l.get(1);
            if (map.get(i1) == null) {
                map.put(i1, new ArrayList<>());
            } 
            map.get(i1).add(i2);
            
            
            if (map.get(i2) == null) {
                map.put(i2, new ArrayList<>());
            } 
            map.get(i2).add(i1);
            
        }
        
        q.offer(cur.get(0).get(0));
        visited.add(cur.get(0).get(0));
        
        while(!q.isEmpty()) {
            int value = q.poll();
            
            for (int neighbor : map.get(value)) {
                if (!visited.contains(neighbor)) {
                    q.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        
        return visited.size() != n;
    }
}


class CriticalConnections {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (List<Integer> oneConnection : connections) {
            graph[oneConnection.get(0)].add(oneConnection.get(1));
            graph[oneConnection.get(1)].add(oneConnection.get(0));
        }
        
        int[] timer = new int[1];
        List<List<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] timeStampAtThatNode = new int[n];
        criticalConnectionsUtils(graph, -1, 0, timer, visited, results, timeStampAtThatNode);
        
        return results;
    }
    
    private void criticalConnectionsUtils(List<Integer>[] graph, int parent, int node, int[] timer, boolean[] visited, List<List<Integer>> results, int[] timeStampAtThatNode) {
        visited[node] = true;
        timeStampAtThatNode[node] = timer[0]++;
        
        int currentTimeStamp = timeStampAtThatNode[node];
        
        for(int oneNeighbor : graph[node]) {
            if (oneNeighbor == parent) 
                continue;
            
            if (!visited[oneNeighbor])
                criticalConnectionsUtils(graph, node, oneNeighbor, timer, visited, results, timeStampAtThatNode);
            
            timeStampAtThatNode[node] = Math.min(timeStampAtThatNode[node], timeStampAtThatNode[oneNeighbor]);
            if (currentTimeStamp < timeStampAtThatNode[oneNeighbor])
                results.add(Arrays.asList(node, oneNeighbor));
        }
    }
}
