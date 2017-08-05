public class ValidTree {
    
    class UF {
        int[] father = null;
      
        public UF(int n) {
            father = new int[n];
          
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }
      
        private int find(int x) {
            if (father[x] == x) {
                return x;
            }
          
            return father[x] = find(father[x]);
        }
      
        public boolean connect (int a, int b) {
            int father_a = find(a);
            int father_b = find(b);
            
            if (father_a != father_b) {
                father[father_a] = father[father_b];
                return true;
            } 
          
            return false;
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
  
        UF uf = new UF(n);
    
        for (int[] edge: edges) {
            int x = edge[0];
            int y = edge[1];
        
            if (!uf.connect(x,y)) {
                return false;
            }
      
        }
  
        return true;
  
    }
}
