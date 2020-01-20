public class ValidNumber {
    public boolean isNumber(String s) {
        //remove the leading white space
        s = s.trim();
        
        char[] c = s.toCharArray();
        
        int i = 0;
        int num = 0;
        
        //check whether the first character is sign
        if (i < c.length && (c[i] == '+' || c[i] == '-')) 
            i++;
        
        //it should be a number or a point right after the sign
        for (; i < c.length && (c[i] >= '0' && c[i] <= '9'); i++)
            num++;
        if (i < c.length && c[i] == '.') 
            i++;
        
        //if there is only a point before and no digit before the point, there should be a number after the point
        for (; i < c.length && (c[i] >= '0' && c[i] <= '9'); i++)
            num++;
        
        //valid: -.4; 1.3   etc
        if (num == 0) {
            return false;
        }
        
        
        if (i == c.length)
            return true;
        
        //the next valid character if not digit, it should only be 'e'
        else if (i < c.length && c[i] != 'e') {
            return false;
        } else {
            i++;
        }
        //there should be at least a number after sign 'e'
        //valid: -.4e2
        //invalid: -.4e
        num = 0;
        
        //check whether there is a sign there
        if (i < c.length && (c[i] == '+' || c[i] == '-')) 
            i++;
        
        //check whether there are digits afterwards
        for (; i < c.length && (c[i] >= '0' && c[i] <= '9'); i++)
            num++;
        
        if (num == 0) {
            return false;
        }
        
        if (i == c.length)
            return true;
        
        return false;
    }
}

class isNumber {
    public boolean isNumber(String s) {
        
        if (s == null)
            return false;
        int i = 0;
        //多加一位 avoid overflow
        s = s.trim() + " ";
        
        char[] sc = s.toCharArray();
        int len = s.length() - 1;
        
        if (sc[i] == '+' || sc[i] == '-')
            i++;
        
        int nDigit = 0;
        int nPoint = 0;
        //浮点  至少一个数字 至多一个点
        while (Character.isDigit(sc[i]) || sc[i] == '.') {
            if (Character.isDigit(sc[i])) {
                nDigit++;
            } else {
                nPoint++;
            }
            i++;
        }
        
        if (nDigit <= 0 || nPoint > 1)
            return false;
        
        if (sc[i] == 'e') {
            i++;
            if (sc[i] == '+' || sc[i] == '-') {
                i++;
            }
            
            if (i == len) {
                return false;
            }
            
            for (; i < len; i++) {
                if (!Character.isDigit(sc[i])) {
                    return false;
                }
            }
        }
        
        
        return i == len;
        
    }
}
