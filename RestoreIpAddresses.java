class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        if (s == null || s.length() == 0)
            return ret;
        
        helper(ret, new StringBuilder(), 0, 0, s);
        return ret;
    }
    
    private void helper(List<String> ret, StringBuilder sb, int index, int level, String s) {
        if (level > 4 || index > s.length()) {
            return;
        }
        
        if (level == 4 && index == s.length()) {
            ret.add(sb.toString());
            return;
        }
        
        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length())
                break;
            
            String sub = s.substring(index, index + i);
            int num = Integer.parseInt(sub);
            if (i == 1 || i == 2 && num >= 10 && num <= 99 || i == 3 && num >= 100 && num <= 255) {
                sb.append(num);
                if (level < 3)
                    sb.append(".");
                helper(ret, sb, index + i, level + 1, s);
                if (level < 3)
                    sb.deleteCharAt(sb.length() - 1);
                sb.delete(sb.length() - i, sb.length());
            }
                
            
        }
    }
}
