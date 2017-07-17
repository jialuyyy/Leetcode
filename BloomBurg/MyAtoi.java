//minus and positive
//invalid input the characters are not all integers
//overflow
//leading spaces
public class MyAtoi {
    public int myAtoi(String str) {
        //remove all the leading spaces
        str = str.trim();
        
        int i = 0;
        int base = 0;
        int sign = 1;
        
        if (i < str.length() && str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < str.length() && str.charAt(i) == '+') {
            sign = 1;
            i++;
        }
        
        while (i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0' ) {
            //check overflow
            if (base > Integer.MAX_VALUE / 10 || base == Integer.MAX_VALUE / 10 && str.charAt(i) > '7') {
                if (sign == 1)
                    return Integer.MAX_VALUE;
                else 
                    return Integer.MIN_VALUE;
            }
            base = base * 10 + str.charAt(i) - '0';
            
            i++;
        }
        
        
        return base * sign;
        
    }
}
