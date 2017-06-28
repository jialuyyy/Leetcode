//Time Compleixity: O(V+E)
//build graph using hashmap and create a wrapper class to maintain the string value with the wight value
//use dfs to traverse the graph and add result to the value. pay attention to some edge cases.
//beats 29%
public class CalcEquation {
    //string and the division value
    class Pair {
        String s;
        double d;
        
        public Pair(String s, double d) {
            this.s = s;
            this.d = d;
        }
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] ret = new double[queries.length];
        Map<String, List<Pair>> graph = new HashMap<String, List<Pair>>();
        int count = 0;
        
        //build graph
        for (int i = 0; i < equations.length; i++) {
            String s1 = equations[i][0];
            String s2 = equations[i][1];
            double value = values[i];
            double reverseValue = 1.0 / value;
            
            Pair p1 = new Pair(s2, value);
            Pair p2 = new Pair(s1, reverseValue);
            if (!graph.containsKey(s1)) {
                List<Pair> list = new ArrayList<Pair>();
                list.add(p1);
                graph.put(s1, list);
            } else {
                graph.get(s1).add(p1);
            }
            
            if (!graph.containsKey(s2)) {
                List<Pair> list = new ArrayList<Pair>();
                list.add(p2);
                graph.put(s2, list);
            } else {
                graph.get(s2).add(p2);
            }
        }
        
        
        for (int i = 0; i < queries.length; i++) {
            String source = queries[i][0];
            String dest = queries[i][1];
            Set<String> visited = new HashSet<String>();
            
            dfs(graph, source, dest, visited, 1.0, i, ret);
            
            if (ret[i] == 0 && !source.equals(dest)) {
                ret[i] = -1.0;
            }
        }
        
        
        return ret;
    
    }
    
    private void dfs(Map<String, List<Pair>> graph, String source, String dest, Set<String> visited, double value, int index, double[] ret) {
        if (source.equals(dest)) {
            ret[index] = value;
        }
        
        if (visited.contains(source)) {
            return;
        }
        
        visited.add(source);
        
        if (!graph.containsKey(source) || !graph.containsKey(dest)) {
            ret[index] = -1.0;
            return;
        }
        
        List<Pair> list = graph.get(source);
        if (list != null && list.size() > 0)
            for (Pair n: list) {
                dfs(graph, n.s, dest, visited, value * n.d, index, ret);
            }
        
    }
}
