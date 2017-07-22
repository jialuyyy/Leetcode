/*public String(char[] value,
      int offset,
      int count)*/
//offset is the initial index of the substring and count is the length of the subsring

//1432219
//1219

//iterate over the whole string, keep removing the previous element before the current element
//if the previous value is larger than current value, but the removing count should not be larger than k

//Time complexity: O(n)
//Space Complexity : O(n)
public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        int resultLength = num.length() - k;
        
        char[] arr = new char[num.length()];
        
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (top > 0 && arr[top - 1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            
            arr[top++] = c;
        }
        
        int index = 0;
        while (index < resultLength && arr[index] == '0') {
            index++;
        }
        
        return index == resultLength ? "0" : new String(arr, index, resultLength - index);
        
        
    }
}
