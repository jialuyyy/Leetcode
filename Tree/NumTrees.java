//dp[i] denotes the number of the binary search trees that the nodes are from 1 to n
//dp[0] = 1;
// dp[1] = 1;

/*
 dp[2] = dp[0]* dp[1] + dp[1] * dp[0];
 
 2    1
1      2
*/
public class NumTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
               dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        
        return dp[n];
    }
}

/*
G(n): totoal number of unique BST
F(i, n): number of unique BST with i as its root, 1 to i - 1 lay on its left and i + 1 to n lay on its right

F(3, 7) = G(2) * G(4)

F(i, n) = G(i - 1) * G(n - i)  i from 1 to n

G(n) = G(0) * G(n - 1) + G(1) * G(n - 2) +.......G(n - 1) * G(0) 
*/
public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
               dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        
        return dp[n];
    }
}
