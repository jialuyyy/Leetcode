class LastSubstring {
    public String lastSubstring(String s) {
        char[] str = s.toCharArray();
        char curMax = 'a';
        
        List<Integer> candidatesPos = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= curMax) {
                if (str[i] > curMax) {
                    candidatesPos.clear();
                }
                
                candidatesPos.add(i);
                curMax = str[i];
            }
        }
        
        if (candidatesPos.size() == 1)
            return s.substring(candidatesPos.get(0));
        
        int prePos = candidatesPos.get(0);
        int len = candidatesPos.size();
        for (int i = 1; i < candidatesPos.size(); i++) {
            int curPos = candidatesPos.get(i);
            
            while (i < len - 1 && candidatesPos.get(i + 1) - candidatesPos.get(i) == 1) {
                i++;
            }
            
            for (int k = 0; k < str.length - curPos; k++) {
                if (str[prePos + k] > str[curPos + k])
                    break;
                
                if (str[prePos + k] < str[curPos + k]) {
                    prePos = curPos;
                    break;
                }
            }
        }
        
        return s.substring(prePos);
    }
}
