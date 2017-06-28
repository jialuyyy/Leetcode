//Time Complexity: O(n)
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null) {
            return b;
        }
        
        if (b == null) {
            return a;
        }
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(j);
            
            int sum = c1 - '0' + c2 - '0' + carry;
            int val = sum % 2;
            carry = sum / 2;
            
            sb.insert(0, (char)(val + '0'));
            i--;
            j--;
        }
        
        while (i >= 0) {
            char c = a.charAt(i);
            int sum = c - '0' + carry;
            int val = sum % 2;
            carry = sum / 2;
            sb.insert(0, (char)(val + '0'));
            i--;
        }
        
        while (j >= 0) {
            char c = b.charAt(j);
            int sum = c - '0' + carry;
            int val = sum % 2;
            carry = sum / 2;
            sb.insert(0, (char)(val + '0'));
            j--;
        }
        
        if (carry > 0) {
            sb.insert(0, (char)(carry + '0'));
        }
        
        return sb.toString();
    }
    
}
