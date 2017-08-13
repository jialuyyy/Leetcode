public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[]  i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });
        
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        int global = 1;
        for (int i = 1; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            global = Math.max(global, dp[i]);
        }
        
        return global;
    }
}
