class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ret = new ArrayList<>();
        if (strings == null || strings.length == 0)
            return ret;
        
        
        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strings) {
            if (s == null || s.length() == 0)
                continue;
            
            char[] ch = s.toCharArray();
            StringBuilder key = new StringBuilder();
            int steps = ch[0] - 'a';
            for (int i = 0; i < ch.length; i++) {
                char c = (char) (ch[i] - steps);
                if (c < 'a') {
                    c += 26;
                }
                
                key.append(String.valueOf(c));
            }
            
            String keys = key.toString();
            if(!groups.containsKey(keys)) {
                groups.put(keys, new ArrayList<>());
            }
            
            groups.get(keys).add(s);
        }
        
        return new ArrayList(groups.values());
    }
}
