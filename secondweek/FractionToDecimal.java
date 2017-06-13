//beats 28.25%
//many corner cases to consider, not easy to implement

public class FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return "";
        }
        
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        
        res.append((numerator > 0) ^ (denominator > 0) ? "-":"");
        
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        res.append(num / den);
        num = num % den;
        if (num == 0) {
            return res.toString();
        }
        
        res.append(".");
        
        //maintain the number and the index pair
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        
        while (num != 0) {
            num *= 10;
            
            res.append(num / den);
            
            num %= den;
            
            if (map.get(num) != null) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            } else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}
