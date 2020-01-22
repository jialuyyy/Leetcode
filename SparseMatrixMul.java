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


class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        
        int n = A.length;
        int m = B[0].length;
        int t = A[0].length;
        
        int[][] C = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < t; k++) {
                //optimise many 0 in the matrix
                if (A[i][k] == 0)
                    continue;
                for (int j = 0; j < m; j++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
        return C;
    }
}


class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        
        int n = A.length;
        int m = B[0].length;
        int t = A[0].length;
        
        int[][] C = new int[n][m];
        
        //optimize keep a list of all the col index of each row in B that is not 0
        List<List<Integer>> colIndex = new ArrayList<>();
        
        for (int i = 0; i < t; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                if (B[i][j] != 0) {
                    list.add(j);
                }
            }
            colIndex.add(list);
        }
        
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < t; k++) {
                if (A[i][k] == 0)
                    continue;
                for (int j : colIndex.get(k)) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
        return C;
    }
}
