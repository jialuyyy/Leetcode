//too many corner cases to take care
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (org == null || seqs == null) {
            return false;
        }
        
        boolean valid = false;
        if (org.length > 0) {
            if (seqs.size() == 0) {
                return false;
            }
            for (List<Integer> seq: seqs) {
                if (seq.size() > 0) {
                    valid = true;
                }
            }
        }
        
        if (!valid) {
            return false;
        }
        
        Map<Integer, Set<Integer>> neighbors = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();
        
        int n = org.length;
        for (int i = 1; i <= n; i++) {
            indegree.put(i, 0);
            neighbors.put(i, new HashSet<Integer>());
        }
        
        for (List<Integer> seq: seqs) {
            int size = seq.size();
            if (seq.size() == 1) {
                if (seq.get(0) < 1 || seq.get(0) > n) {
                    return false;
                }
            }
            for (int i = 0; i < size - 1; i++) {
                int i1 = seq.get(i);
                int i2 = seq.get(i + 1);
                
                if (i1 < 1 || i1 > n || i2 < 1 || i2 > n) {
                    return false;
                }
                if (!neighbors.get(i1).contains(i2)) {
                    indegree.put(i2, indegree.get(i2) + 1);
                    neighbors.get(i1).add(i2);
                }
            }
        }
        
        Deque<Integer> q = new ArrayDeque<Integer>();
        
        for (int i = 1; i <= n; i++) {
            if (indegree.get(i) == 0) {
                q.offer(i);
            }
        }
        
        if (q.size() != 1) {
            return false;
        }
        
        int index = 0;
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (size != 1) {
                return false;
            }
            
            int cur = q.poll();
            count++;
            if (cur != org[index++]) {
                return false;
            }
            for (int neighbor: neighbors.get(cur)) {
                int in = indegree.get(neighbor) - 1;
                if (in == 0) {
                    q.offer(neighbor);
                }
                
                indegree.put(neighbor, in);
            }
        }
        
        return count == n;
        
    }
}
