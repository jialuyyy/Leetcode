// use a hashmap to keep the frequency of every sub string
//iterate over the whole string from the start to the end to check all the substring of the size of 10, if it is already in the hashmap
//which means it is a repetitive one. needs optimization

public class FindRepeatedDnaSequences{
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return ret;
        }
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            
            if (map.get(sub) == null) {
                map.put(sub, 1);
            } else {
                map.put( sub, map.get(sub) + 1);
                if (!ret.contains(sub))
                   ret.add(sub);
            }
        }
        
        return ret;
        
        
    }
}
