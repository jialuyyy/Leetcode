class SparseMatrixMul {
    public int[][] multiply(int[][] A, int[][] B) {
        
        int n = A.length;
        int m = B[0].length;
        int t = A[0].length;
        
        int[][] C = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < t; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
        return C;
    }
}
