public class FindCircleNum {
    
    class UF {
        private int[] father = null;
        private int count = 0;
        public UF(int m) {
            father = new int[m];
            for (int i = 0; i < m; i++) {
                father[i] = i;
            }
        }
        
        public int find (int x) {
            if (father[x] == x) {
                return x;
            }
            
            return father[x] = find(father[x]);
        }
        
        public void connect(int a, int b) {
            int father_a = find(a);
            int father_b = find(b);
            if (father_a != father_b) {
                father[father_a] = father[father_b];
                count--;
            }
        }
        
        private void setCount(int count) {
            this.count = count;
        }
        
        private int query() {
            return this.count;
        }
    }
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        
        int rows = M.length;
        int cols = M[0].length;
        UF root = new UF(rows);
        root.setCount(rows);
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (M[i][j] == 1) {
                    for (int k = 0; k < cols; k++) {
                        if (M[i][k] == 1) {
                            root.connect(j, k);
                        }
                    }
                }
            }
        }
        
        
        return root.query();
        
    }
}
