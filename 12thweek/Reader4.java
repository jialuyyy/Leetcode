/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    //tmp is the temporary buffer used to keep the characters read from the API
    //the problem description is not clear
    
    private char[] tmp = new char[4];
    public int read(char[] buf, int n) {
        
        //count keeps the number of characters in the destination
        int count = 0;
        while (count < n) {
            int len = read4(tmp);
            for (int i = 0; i < len; i++) {
                buf[count++] = tmp[i];
                //if count reaches n, return count
                if (count >= n) {
                    return count;
                }
            }
            
            //if the len < 4, which means the file is reaching the end, so return
            if (len < 4) {
                return count;
            }
        }
        
        return count;
    }
}
