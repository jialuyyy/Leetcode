//if two string both are nodes of the graph, but they are neither connected directly nor directly, the dfs ret value would be null, and
//set the actual ret to be -0.1, if we use a double[] ret directly in the dfs method, in this situation ,the ret value would be 0.0 and 
// it is hard to judge whether it is actual 0.0 or is the situation above.

//beats 23%
public class CalcEquation {
    class Pair {
        String s;
        double d;
        
        public Pair (String s, double d) {
            this.s = s;
            this.d = d;
        }
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] ret = new double[queries.length];
        Map<String, List<Pair>> map = new HashMap<String, List<Pair>>();
        
        //build graph
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            double value = values[i];
            double reverseValue = 1.0 / value;
            
            String str1 = equation[0];
            String str2 = equation[1];
            
            if (map.get(str1) == null) {
                map.put(str1, new ArrayList<Pair>());
            }
            
            map.get(str1).add(new Pair(str2, value));
            
            if (map.get(str2) == null) {
                map.put(str2, new ArrayList<Pair>());
            }
            
            map.get(str2).add(new Pair(str1, reverseValue));
        }
        
        //dfs
        
        Double[] tmp = new Double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            String s = query[0];
            String d = query[1];
            
            //contains visted string
            Set<String> set = new HashSet<String>();
            dfs(map, s, d, 1.0, set, i, tmp);
        
        }
        
        for (int i = 0; i < ret.length; i++) {
            if (tmp[i] == null) {
                ret[i] = -1.0;
            } else {
                ret[i] = tmp[i];
            }
        }
        return ret;
    }
    
    private void dfs(Map<String, List<Pair>> map, String s, String d, double value, Set<String> set, int i, Double[] ret) {
        if (s.equals(d) && map.get(s) != null) {
            ret[i] = value;
            return;
        }
        
        if (set.contains(s)) {
            return;
        }
        
        set.add(s);
        
        if (map.get(s) == null || map.get(d) == null) {
            ret[i] = -1.0;
            return;
        }
        
        List<Pair> neighbors = map.get(s);
        
        for (Pair neighbor: neighbors) {
            dfs(map, neighbor.s, d, value * neighbor.d, set, i, ret);
        }
        
    }
}
