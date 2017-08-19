/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

/*the read function may be called in the middle of the copying process
In other words, when the words is written from the temp buffer to the destination buffer and has not been finished yet,
the read function is called again, then there will be some characters that have not been copied to the destination.

Therefore, we need to maintain another pointer to track the characters copied from the tmp buffer to the destination buffer
if the pointer has not reached the end of the tmp buffer, we are not allowed to read from the source file.
*/


public class Solution extends Reader4MultipleTimes {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] tmp = new char[4];
    private int offSet = 0;
    private int remaining = 0;
    private boolean isEndOfFile = false;
    
    public int read(char[] buf, int n) {
        int total = 0;
        
        while (total < n && (remaining != 0 || !isEndOfFile)) {
            int len = 0;
            if (remaining != 0) {
                len = remaining;
            } else {
                offSet = 0;
                len = read4(tmp);
                if (len != 4) {
                    isEndOfFile = true;
                }
            }
            
            int length = Math.min(n - total, len);
            
            //read from the offset
            for (int i = offSet; i < offSet + length; i++) {
                buf[total++] = tmp[i];
            }
            
            //update the offset
            remaining = len - length;
            if (remaining != 0) {
                offSet = offSet + length;
            }
        }
        
        return total;
    }
}
