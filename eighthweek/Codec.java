public class Codec {
    
    //pack the length of the string with a sign for example if the input string list
    //is "abc" "def" "ghi#jk"
    //the encoded string would be "3#abc3#def6#ghi#jk"
    
    //when do the encode, find the first pos of the sign
    //the length of the substring will be Integer.parseInt(s.substring(start, index))
    
    //find the substring from(index + 1, index + size + 1)

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null || strs.size() == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < strs.size(); i++) {
            String cur = strs.get(i);
            
            sb.append(String.valueOf(cur.length()) + "#");
            sb.append(cur);
        }
        
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ret = new ArrayList<String>();
        if (s.length() == 0) {
            return ret;
        }
        
        int start = 0;
        
        while (start < s.length()) {
        //find the first index of "#" from the index start
        //the substring between start and the index would be the size of the next string
        //the next string would be the substring from index + 1 to index + size + 1
        //update the start index to find the next "#"
            int index = s.indexOf("#", start);
            
            int size = Integer.parseInt(s.substring(start, index));
            
            String sub = s.substring(index + 1, index + size + 1);
            
            ret.add(sub);
            
            start = index + 1 + size;
        }
        
        return ret;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
