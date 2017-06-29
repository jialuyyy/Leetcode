/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
//characters in the previous call may have not been used up
//so need to maintain two pointers to check whether the previous characters have been used up
//if the tmpPtr is increased to the value of buffCounter, which means the previous characters already been used up and need to read more
//and the temp pointer should be set to 0
public class Reader42 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int tmpPtr = 0;
    private int buffCounter = 0;
    private char[] tmp = new char[4];
    
    public int read(char[] buf, int n) {
        int count = 0;
        
        while (count < n) {
            if (tmpPtr == 0) {
                buffCounter = read4(tmp);
            }
            
            while (count < n && tmpPtr < buffCounter) {
                buf[count++] = tmp[tmpPtr++];
            }
            
            if (tmpPtr == buffCounter) {
                tmpPtr = 0;
            }
            
            //reach the end of the file
            if (buffCounter < 4) {
                break;
            }
        }
        
        return count;
    }
}
