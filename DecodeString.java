class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return "";
        //3[a2[c]]
        // number : 3 2
        // strings : a
        //accaccacc
        
        
        //3[a]2[bc]
        //aaa bcbc
        Deque<Integer> number = new ArrayDeque<>();
        Deque<String> strings = new ArrayDeque<>();
        
        int index = 0;
        String res = "";
        while (index < s.length()) {
            //if current character is number
            if (Character.isDigit(s.charAt(index))) {
                int count = s.charAt(index) - '0';
                index++;
                while(Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                number.push(count);
            } else if (s.charAt(index) == '[') {
                strings.push(res);
                res = "";
                index++;
            } else if (s.charAt(index) == ']') {
                StringBuilder sb = new StringBuilder(strings.pop());
                int repeatedTimes = number.pop();
                
                for(int i = 0; i < repeatedTimes; i++) {
                    sb.append(res);
                }
                
                res = sb.toString();
                index++;
            //if current character is letter
            } else {
                res += s.charAt(index);
                index++;
            }
        }
        
    
        return res;
        
        
    } 
}
