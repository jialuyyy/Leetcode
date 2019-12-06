class CountAndSay {
    public String countAndSay(int n) {
        StringBuilder cur = new StringBuilder("1");
        StringBuilder prev = null;
        
        for (int i = 1; i < n; i++) {
            prev = cur;
            
            int count = 1;
            char say = prev.charAt(0);
            cur = new StringBuilder();
            
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) == say) {
                    count++;
                } else {
                    cur.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                }
            }
            
            cur.append(count).append(say);
        }
        
        return cur.toString();
        
    }
}
