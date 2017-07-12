//iterate over the words array to maintain the newLen in a variable newLen
//newLen = totalLength from words 0 to i + spaces number
//curLen = totalLength of words
//if (newLen <= maxWidth), update the end to current word and uodate the curLen and i
//if (newLen > maxWidth), build a string and update the start to the next word, set the curLen to 0
//in the buildString method
//for the last line or the one word line, put all the remaining spaces to the end of the line
//for other lines, average space number is (maxWidth - curLen) / (n - 1) and the number of partitions that need to be assigned one more space
//is (maxWidth - curLen) % ( n - 1)
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<String>();
        if (words == null) {
            return ret;
        }
        
        int i = 0;
        int start = 0;
        int end = -1;
        int curLen = 0;
        while (i < words.length) {
            //words length + space length
            if (words[i].length() > maxWidth) {
                return ret;
            }
            int newLen = curLen + words[i].length() + (end - start + 1);
            if (newLen <= maxWidth) {
                end = i;
                curLen += words[i].length();
                i++;
            } else {
                String s = createNewLine(words, maxWidth, start, end, curLen, false);
                ret.add(s);
                start = i;
                end = i - 1;
                curLen = 0;
            }
        }
        String s = createNewLine(words, maxWidth, start, end, curLen, true);
        ret.add(s);
        
        return ret;
        
    }
    
    private String createNewLine(String[] words, int maxWidth, int start, int end, int curLen, boolean isLast) {
        StringBuilder s = new StringBuilder();
        
        //patition number + 1
        if (start < 0 || end >= words.length || start > end) {
            return s.toString();
        }
        int n = end - start + 1;
        s.append(words[start]);
        
        if (n == 1 || isLast) {
            for (int i = start + 1; i <= end; i++) {
                s.append(" " + words[i]);
            }
            
            int spacesLeft = maxWidth - curLen - (n - 1);
            for (int j = 0; j < spacesLeft; j++)
                s.append(" ");
            return s.toString();
        }
        
        int k = (maxWidth - curLen) / (n - 1);
        int m = (maxWidth - curLen) % (n - 1);
        
        for (int i = start + 1; i <= end; i++) {
            int spacesNumber = i - start <= m ? k + 1 : k;
            for (int j = 0; j < spacesNumber; j++)
                s.append(" ");
            s.append(words[i]);
        }
        
        return s.toString();
    }
}
