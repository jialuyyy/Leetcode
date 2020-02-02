class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> ret = new ArrayList<>();
        if(s == null || p == null || s.length() < p.length())
            return ret;
        
        int[] map = new int[256];
        for (char c : p.toCharArray())
            map[c]++;
        
        int start = 0;
        int end = 0;
        int count = p.length();
        
        while (end < s.length()) {
            
            if (map[s.charAt(end++)]-- > 0)
                count--;
            
            if (count == 0)
                ret.add(start);
            
            if (end - start == p.length() && map[s.charAt(start++)]++ >= 0)
                count++;
        }
        
        return ret;
    }
}

class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length())
            return ans;
        
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        
        int[] det = new int[256];
        
        for (int i = 0; i < p.length(); i++) {
            det[pc[i]]--;
            det[sc[i]]++;
        }
        int absSum = 0;
        
        for (int item : det) {
            absSum += Math.abs(item);
        }
        
        if (absSum == 0)
            ans.add(0);
        
        for (int i = p.length(); i < s.length(); i++) {
            int r = sc[i];
            int l = sc[i - p.length()];
            
            absSum = absSum - Math.abs(det[r]) - Math.abs(det[l]);
            
            //update the hash
            det[r]++;
            det[l]--;
            
            absSum = absSum + Math.abs(det[r]) + Math.abs(det[l]);
            
            if (absSum == 0)
                ans.add(i - p.length() + 1);
        }
        
        return ans;
    }
}
