/*
s3 = "aadbbcbcac"
s1 = "aabcc"
s2 = "dbbca"
*/

/*  d b b c a
  T F F F F F
a T F F F F F
a T T T T T F
b F T T F T F
c F F T T T T
c F F F T F T

*/

public class isInterLeave {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        boolean[][] matrix = new boolean[s1.length() + 1][s2.length() + 1];
        matrix[0][0] = true;
        
        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] = matrix[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        
        for (int i = 1; i < matrix[0].length; i++) {
            matrix[0][i] = matrix[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = (matrix[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) ||
                               (matrix[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }
        
        return matrix[s1.length()][s2.length()];
    }
}
