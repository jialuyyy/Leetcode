public class NumIslands2 {
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};
    class UF {
        int[] father = null;
        
        public UF(int m) {
            father = new int[m];
            for (int i = 0; i < m; i++) {
                father[i] = i;
            }
        }
        
        private int find(int x) {
            if (father[x] == x) {
                return x;
            }
            
            return father[x] = find(father[x]);
        }
        
        public boolean connect(int a, int b) {
            int father_a = find(a);
            int father_b = find(b);
            
            if (father_a != father_b) {
                father[father_a] = father_b;
                return true;
            }
            
            return false;
        }
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ret = new ArrayList<Integer>();
        if (positions == null || positions.length == 0) {
            return ret;
        }
        int count = 0;
        int[][] grid = new int[m][n];
        
        UF root = new UF(m * n);
        
        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            
            grid[x][y] = 1;
            count++;
            for (int k = 0; k < 4; k++) {
                int index_x = x + dx[k];
                int index_y = y + dy[k];
                
                if (index_x >= 0 && index_x < m && index_y >= 0 && index_y < n) {
                    if (grid[index_x][index_y] == 1) {
                        if (root.connect(x * n + y, index_x * n + index_y)) {
                            count--;
                        }
                    }
                }
            }
            
            ret.add(count);
        }
        
        return ret;
    }
}
