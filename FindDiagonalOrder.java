/*Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]*/

class FindDiagonalOrder {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[]{};
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int r = 0;
        int c = 0;
        
        int[] arr = new int[rows * cols];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = matrix[r][c];
            
            if ((r + c) % 2 == 0) {
                if (c == cols - 1) {
                    r++;
                } else if (r == 0) {
                    c++;
                } else {
                    r--;
                    c++;
                }
            } else {
                if (r == rows - 1) {
                    c++;
                } else if (c == 0) {
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }
        
        return arr;
        
    }
}
