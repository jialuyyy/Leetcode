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



/*instead of hashing or storing strings themselves the solution converts 10 letter string into 4-bytes integer (which is much smaller than string in terms of consumed memory). This would not be possible if the string could contain all 26 letters of English alphabet for example. But it is possible for our case, because there can be only 'A', 'C', 'G' and 'T' letters.

So we have only 4 possible letters, and we can use as little bits as possible to store each character of our 10-letter string. We really need only 2 bits (bits, not bytes) for this. Specifically the solution uses the following coding:

0 = 00 (bits in binary number system) = 'A'

1 = 01 (bits in binary number system) = 'C'

2 = 10 (bits in binary number system) = 'G'

3 = 11 (bits in binary number system) = 'T'
*/

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new ArrayList<String>();
        
        char[] map = new char[26];
        //only needs two bit to represent each character of the 4 characters
        
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        if (s == null || s.length() == 0) {
            return ret;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> doubleSet = new HashSet<Integer>();
        
        for (int i = 0; i <= s.length() - 10; i++) {
            int v = 0;
            for (int j = i; j < i + 10; j++) {
                v <<= 2;
                v |= map[s.charAt(j) - 'A'];
            }
            
            if (!set.add(v) && doubleSet.add(v)) {
                ret.add(s.substring(i, i + 10));
            }
            
        }
        
        return ret;
        
        
    }
}
