class ValidIPAddress {
    public String validIPAddress(String IP) {
        if (isValidIPv4(IP))
            return "IPv4";
        
        if (isValidIPv6(IP))
            return "IPv6";
        
        return "Neither";
    }
    
    private boolean isValidIPv4(String IP) {
        int cnt = 0;
        for (char ch : IP.toCharArray()) {
            if (ch == '.')
                cnt++;
        }
        
        if (cnt != 3)
            return false;
        
        String[] fields = IP.split("\\.");
        if (fields.length != 4)
            return false;
        
        for (String field : fields) {
            if (field.isEmpty() || field.length() > 3)
                return false;
            
            int sz = field.length();
            for (int i = 0; i < sz; i++) {
                if (!Character.isDigit(field.charAt(i)))
                    return false;
            }
            
            int num = Integer.valueOf(field);
            if (!String.valueOf(num).equals(field) || num < 0 || num > 255)
                return false;
        }
        
        return true;
    }
    
    private boolean isValidIPv6(String IP) {
        int cnt = 0;
        for (char ch : IP.toCharArray()) {
            if (ch == ':')
                cnt++;
        }
        
        if (cnt != 7)
            return false;
        
        String[] fields = IP.split(":");
        if (fields.length != 8)
            return false;
        String hexdigits = "0123456789abcdefABCDEF";
        for (String field : fields) {
            if (field.isEmpty() || field.length() > 4)
                return false;
            
            int sz = field.length();
            for (int i = 0; i < sz; i++) {
                if (hexdigits.indexOf(field.charAt(i)) == -1)
                    return false;
            }
        }
        
        return true;
    }
}
