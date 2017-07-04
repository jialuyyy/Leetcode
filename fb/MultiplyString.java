public class MultiplyString {
    public String multiply(String num1, String num2) {
        int mLen = num1.length();
        int nLen = num2.length();
        
        int[] ret = new int[mLen + nLen];
        for (int i = mLen - 1; i >= 0; i--) {
            for (int j = nLen - 1; j >= 0; j--) {
                int c1 = num1.charAt(i) - '0';
                int c2 = num2.charAt(j) - '0';
                
                int pos1 = i + j;
                int pos2 = i + j + 1;
                
                int sum = c1 * c2 + ret[pos2];
                
                ret[pos1] += sum / 10;
                ret[pos2] = sum % 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i: ret) {
            if (!(sb.length() == 0 && i == 0))
                sb.append(i);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
