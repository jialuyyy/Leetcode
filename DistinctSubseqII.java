class DistinctSubseqII {
    public int distinctSubseqII(String S) {
        if (S == null || S.length() == 0)
            return 0;
        int MOD = 1_000_000_007;
        
        int[] dp = new int[S.length() + 1];
        dp[0] = 1;
        
        int[] last = new int[26];
        Arrays.fill(last, -1);
        
        for (int i = 0; i < S.length(); i++) {
            int x = S.charAt(i) - 'a';
            
            dp[i + 1] = dp[i] * 2 % MOD;;
            if (last[x] >= 0)
                dp[i + 1] -= dp[last[x]];
            dp[i+1] %= MOD;
            last[x] = i;
        }
        
        dp[S.length()]--;
        
        if (dp[S.length()] < 0) dp[S.length()] += MOD;
        return dp[S.length()];
    }
}
