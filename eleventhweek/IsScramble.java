public class IsScramble {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        //whether s1 and s2 contains same characters
        int[] hash = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            hash[s1.charAt(i) - 'a']++;
            hash[s2.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }
        
        for (int i = 1; i < s1.length(); i++) {
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s1.length() - i))) 
                  return true;
               
        }
               
        return false;
    }
}


public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        //whether s1 and s2 contains same characters
        int[] hash = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            hash[s1.charAt(i) - 'a']++;
            hash[s2.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }
        
        int len = s1.length();
        //i: start index of s1
        //j: start index of s2;
        //k: length of the two string
        boolean[][][] dp = new boolean[len][len][len + 1];
        
        for (int subLen = 1; subLen <= len; subLen++) {
            for (int i1 = 0; i1 <= len -subLen; i1++) {
                for (int i2 = 0; i2 <= len - subLen; i2++) {
                    if (subLen == 1) {
                        dp[i1][i2][subLen] = s1.charAt(i1) == s2.charAt(i2);
                        continue;
                    }
                    
                    for (int l = 1; l < subLen; l++) {
                        if (dp[i1][i2][l] && dp[i1 + l][i2 + l][subLen - l] ||
                           dp[i1][i2 + subLen - l][l] && dp[i1 + l][i2][subLen - l]) {
                            dp[i1][i2][subLen] = true;
                            break;
                        }
                    }
                    
                }
            }
        }
               
        return dp[0][0][len];
    }
}
