class AddStrings {
    public String addStrings(String num1, String num2) {
        
        if (num1 == null && num2 == null)
            return "";
        if (num1 == null && num2 != null)
            return num2;
        if (num1 != null && num2 == null)
            return num1;
        
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        String ret = "";
        while (i >= 0 || j >= 0) {
            int num = carry;
            
            if (i >= 0) {
                num += (num1.charAt(i) - '0');
                i--;
            }
            
            if (j >= 0) {
                num += (num2.charAt(j) - '0');
                j--;
            }
            
            int mod = num % 10;
            carry = num / 10;
            
            ret = mod + ret;
        }
        
        if (carry > 0) {
            ret = "1" + ret;
        }
        
        return ret;
    }
}

//use stringbuilder is much faster than using string
class AddStrings {
    public String addStrings(String num1, String num2) {
        
        if (num1 == null && num2 == null)
            return "";
        if (num1 == null && num2 != null)
            return num2;
        if (num1 != null && num2 == null)
            return num1;
        
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int num = carry;
            
            if (i >= 0) {
                num += (num1.charAt(i) - '0');
                i--;
            }
            
            if (j >= 0) {
                num += (num2.charAt(j) - '0');
                j--;
            }
            
            int mod = num % 10;
            carry = num / 10;
            
            sb.append(mod);
        }
        
        if (carry > 0) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
}
