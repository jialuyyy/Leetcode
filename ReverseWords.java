class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;
        
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                String sub = s.substring(j, i);
                String swaped = swap(sub);
                sb.append(swaped + " ");
                j = i + 1;
            } 
            
            i++;
        }
        
        String sub = s.substring(j, i);
        String swaped = swap(sub);
        sb.append(swaped);
       
        return sb.toString();
    }
    
    private String swap(String s) {
        char[] ch = s.toCharArray();
        int start = 0;
        int end = ch.length - 1;
        
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            
            start++;
            end--;
        }
        
        return String.valueOf(ch);
    }
}
