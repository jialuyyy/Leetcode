//dp[i] represents the decoding way for substring (0, i)
//the dp thought is like climbing stairs, for the dp[i], check the next character and next two characters, the dp[i + 1] = dp[i - 1] + dp[i - 2],
//if the current substring is valid
//corner case is character '0', if the first character is '0', which means the substring is invalid, so do not need to update the dp value
//Time Complexity : O(n)
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        
        if (isValid(s.substring(0, 1))) {
            dp[1] = 1;
        } else {
            dp[1] = 0;
        }
        
        for (int i = 2; i <= s.length(); i++) {
            if (isValid(s.substring(i - 1, i))) {
                dp[i] += dp[i - 1];
            } 
            
            if (isValid(s.substring(i - 2, i))) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[s.length()];
    }
    
    private boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        
        int i = Integer.parseInt(s);
        return i >= 1 && i <= 26;
    }
}
