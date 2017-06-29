/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

//the characters will be written to the tmp buffer, use a total variable to maintain the characters read from the file
//every time select the minimum number between the character read from the read4 API and the n - total

public class Reader41 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;
        int total = 0;
        char[] tmp = new char[4];
        
        while (!eof && total < n) {
            //the characters will be written to tmp buffer
            int count = read4(tmp);
            
            if (count < 4) {
                eof = true;
            }
            
            //total is the number of the characters that is already in the buf, n - total will be how many characters left
            count = Math.min(count, n - total);
            
            //copy the characters from tmp to buffer
            for (int i = 0; i < count; i++) {
                buf[total++] = tmp[i];
            }
            
        }
        
        return total;
    }
}
